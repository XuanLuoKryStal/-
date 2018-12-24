package com.example.hystrixtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
@EnableCircuitBreaker  //hystrix dashboard才可以监控？ TODO无效果
public class HystrixTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixTestApplication.class, args);
	}
}
