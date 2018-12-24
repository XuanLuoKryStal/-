package com.example.feigntest.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;

@Configuration
public class FeignTSConfig {

    //表示日志记录哪些内容，但前提是Feign的日志只对Debug级别作出响应（见application.property的设置）
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }

}
