package com.example.feigntest.feignUI;

import com.example.feigntest.config.RibbonTSConfig;
import com.example.feigntest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *  Ribbon与RestTemplate结合使用，实现负载均衡的调用远程服务
 */
@RestController
@RibbonClient(name="random-config",configuration = RibbonTSConfig.class)  //修改策略为随机访问
public class RibbonTSController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "getRibbon",method = RequestMethod.GET)

    public String getRibbonTest(){
        ServiceInstance serviceInstance=loadBalancerClient.choose("eureka-client");
        if(serviceInstance!=null)
        {
            System.out.println("serviceId: "+serviceInstance.getServiceId()+" host: "+serviceInstance.getHost()+
                    " port: "+serviceInstance.getPort());
            String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/getInfo/1";
            System.out.println("HTTP: "+url);
            RestTemplate restTemplate=new RestTemplate();
            User user=restTemplate.getForObject(url, User.class);
            return user.toString();
        }else {
            return "Ribbon cannot get instance of eureka-client";
        }
    }
}
