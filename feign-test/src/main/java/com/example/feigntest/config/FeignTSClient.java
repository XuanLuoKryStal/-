package com.example.feigntest.config;

import com.example.feigntest.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "eureka-client",configuration = FeignTSConfig.class, fallback =FeignFallBackController.class ) //eureka会将eureka-client理解为是服务名
//也可以指定完整URL
//@FeignClient(name = "eureka-client",url = "http://localhost:9090/getInfo/1")
public interface FeignTSClient {

    @RequestMapping(value = "/getInfo/{id}", method = RequestMethod.GET)
    public User getInfo(@PathVariable("id") String id);


}
