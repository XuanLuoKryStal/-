package com.example.feigntest.config;

import com.example.feigntest.entity.User;
import org.springframework.stereotype.Component;

@Component
public class FeignFallBackController implements  FeignTSClient{
    @Override
    public User getInfo(String id) {
        User user=new User();
        user.setName("NULL");
        user.setAge("18");
        user.setId("NULL");
        return user;
    }
}
