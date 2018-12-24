package com.example.feigntest.feignUI;

import com.example.feigntest.config.HttpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  http请求：HttpURLConnection访问
 */
@RestController
public class URLController {
    @Autowired
    private HttpConfig httpConfig;

    @RequestMapping(value = "getHttp",method = RequestMethod.GET)
    public String getHttp(){
        String url="http://localhost:9090/getInfo/1";
        return httpConfig.doGet(url);
    }
}
