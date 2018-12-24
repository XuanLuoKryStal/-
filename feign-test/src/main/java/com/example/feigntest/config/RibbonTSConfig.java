package com.example.feigntest.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  修改Ribbon配置
 *  TODO：为什么这样就可以实现修改Ribbon配置
 */
@Configuration
public class RibbonTSConfig {

    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
