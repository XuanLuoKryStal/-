package com.example.sidecarnode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
//当对应服务安全监测失败时候，sideCarNode也会停掉
@SpringBootApplication
@EnableSidecar
public class SidecarNodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SidecarNodeApplication.class, args);
	}

}

