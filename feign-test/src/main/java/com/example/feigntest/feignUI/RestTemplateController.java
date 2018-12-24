package com.example.feigntest.feignUI;

import com.example.feigntest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *  RestTemplate是spring提供访问Rest请求的工具
 */
@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    //错误方式
//    @LoadBalanced
//    private RestTemplate restTemplate=new RestTemplate();


    //不用注册到Eureka注册中心，相当于HTTP请求
    @RequestMapping(value = "getRestEmpty", method = RequestMethod.GET)   //name接口名称，无实际作用；value请求地址
    public String getRestEmpty() {
        RestTemplate restTemplate=new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:9090/getInfo/1", User.class);
        if (user != null)
            return user.toString();
        else
            return "null";
    }

    //需要引入Ribbon和Eureka包，实现负载均衡作用
    /**
     *  注意：1.@LoadBalanced 需要和 @bean一起使用，才能有负载均衡的效果
     *       2.需要注册到注册中心，才能找到虚拟主机
     *       3.@LoadBalanced是引入ribbon包才有的，且具体实现是引入RibbonLoadBalancerClient
     *  TODO：@LoadBalanced源码研究
     */
    @RequestMapping(value = "getRest", method = RequestMethod.GET)
    public String getRest() {
        //eureka-client为虚拟主机名称
        User user = this.restTemplate.getForObject("http://eureka-client/getInfo/1", User.class);
        if (user != null)
            return user.toString();
        else
            return "null";
    }


    @RequestMapping(value = "postRest",method = RequestMethod.POST)
    public List<User> postRest(@RequestBody User user){
        ResponseEntity<List> responseEntity=this.restTemplate.postForEntity("http://eureka-client/insertInfo",user,List.class);
        List<User> list=responseEntity.getBody();
        return list;
    }

}
