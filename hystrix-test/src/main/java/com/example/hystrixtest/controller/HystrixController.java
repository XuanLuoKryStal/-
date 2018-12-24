package com.example.hystrixtest.controller;

import com.example.hystrixtest.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="getInfoFallBack",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @RequestMapping(value = "getInfo/{id}",method = RequestMethod.GET)
    public String getInfo(@PathVariable("id")String id){
        User user = this.restTemplate.getForObject("http://eureka-client/getInfo/"+id, User.class);
        if(user!=null){
            return  user.toString();
        }else {
            return "null";
        }
    }

    public String getInfoFallBack(String id){
        return "fall back ! id is "+id;
    }

}
