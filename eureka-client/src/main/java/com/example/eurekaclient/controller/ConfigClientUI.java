package com.example.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope   //这样refresh接口才生效
@RestController
public class ConfigClientUI {

    @Value("${spring.cloud.config.profile}")
    private String profile;

    @Value("${type}")
    private String content;

   @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String getProfile(){
       System.out.println("Application: "+profile);
       return this.content;
   }
}
