package com.example.zuulgateway;

import com.example.zuulgateway.controller.ZuulPostFilterController;
import com.example.zuulgateway.controller.ZuulPreFilterController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

    //必须注入实体zuul过滤器才生效
    @Bean
    public ZuulPreFilterController zuulPreFilterController() {
        return new ZuulPreFilterController();
    }

    @Bean
    public ZuulPostFilterController zuulPostFilterController() {
        return new ZuulPostFilterController();
    }

}

