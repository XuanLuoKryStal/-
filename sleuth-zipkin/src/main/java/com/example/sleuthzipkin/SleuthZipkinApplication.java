package com.example.sleuthzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 *  改进方式：
 *  1.数据收集：由HTTP改用中间件Rabbitmq，原因：可能服务之前网络不通
 *  2.持久化：增加es或者mysql等进行数据的收集，原因：zipKin server的数据是存在内存里面，当server服务重启或崩溃，会导致数据丢失
 */
@SpringBootApplication
@EnableZipkinServer
public class SleuthZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthZipkinApplication.class, args);
	}

}

