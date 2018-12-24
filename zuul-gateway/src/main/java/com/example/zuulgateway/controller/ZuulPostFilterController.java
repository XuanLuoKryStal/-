package com.example.zuulgateway.controller;

import com.netflix.zuul.ZuulFilter;
import org.apache.log4j.Logger;

//访问服务之后的Zuul过滤
public class ZuulPostFilterController extends ZuulFilter{
    private  static Logger logger=Logger.getLogger(ZuulPostFilterController.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("Post !!!");
        return null;
    }
}
