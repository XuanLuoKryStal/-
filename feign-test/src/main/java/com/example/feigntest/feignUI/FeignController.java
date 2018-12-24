package com.example.feigntest.feignUI;

import com.example.feigntest.config.FeignTSClient;
import com.example.feigntest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private FeignTSClient feignTSClient;  //必须加上@EnableFeignClients，否则无法注入


    @RequestMapping(value = "getFeign", method = RequestMethod.GET)
    public String getFeignTest() {
        User user = this.feignTSClient.getInfo("1");
        return user.toString();
    }
}
