package com.example.zuulgateway.controller;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

//访问服务之前的Zuul过滤
public class ZuulPreFilterController extends ZuulFilter{
    private static Logger logger=Logger.getLogger(ZuulPreFilterController.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request= requestContext.getRequest();
        logger.info("Pre : "+request.getRequestURL().toString()+ "  "+request.getMethod());
        return null;
    }
}
