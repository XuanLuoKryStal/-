package com.example.zuulgateway.controller;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class ZuulFallBackController implements ZuulFallbackProvider{
    @Override
    public String getRoute() {
        return "eureka-client";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        ClientHttpResponse clientHttpResponse=new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.GATEWAY_TIMEOUT;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 0;
            }

            @Override
            public String getStatusText() throws IOException {
                return "Fall back!";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                String body="NO CONTENT BECAUSE OF FALLING BACK ";
                InputStream inputStream=new ByteArrayInputStream(body.getBytes());
                return inputStream;
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers=new HttpHeaders();
                MediaType mt=new MediaType("application","json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
        return clientHttpResponse;
    }
}
