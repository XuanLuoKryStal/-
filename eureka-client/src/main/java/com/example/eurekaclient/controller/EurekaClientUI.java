package com.example.eurekaclient.controller;

import com.example.eurekaclient.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EurekaClientUI {
    //获取application.properties属性
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String port;

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/getInfo/{id}", method = RequestMethod.GET)
    public User getInfo(@PathVariable String id) {
        User result = new User();
        switch (id) {
            case "1":
                result.setId("1");
                result.setName("Lily");
                result.setAge("15");
                break;
            case "2":
                result.setId("2");
                result.setName("CoCo");
                result.setAge("18");
                break;
            case "3":
                result.setId("3");
                result.setName("David");
                result.setName("25");
                break;
            default:
                result.setId("100");
                result.setName("Hebe");
                result.setAge("19");
                break;
        }
        System.out.println(applicationName+": "+port);
        return result;
    }


    @RequestMapping(value = "/insertInfo", method = RequestMethod.POST)
    public List<User> insertInfo(@RequestBody User user) {  //不能使用@PathVariable
        List<User> result = new ArrayList<>();
        User defaultUser = new User();
        defaultUser.setName("default Name");
        defaultUser.setAge("default Age");
        defaultUser.setId("default Id");
        result.add(defaultUser);
        result.add(user);
        System.out.println(environment.getProperty("spring.application.name")+": "+environment.getProperty("server.port"));
        return result;
    }
}
