package com.example.feigntest.config;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class HttpConfig {
    private Logger logger = Logger.getLogger(HttpConfig.class);

    //GET请求
    public String doGet(String urlPath) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(urlPath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(90000);
            connection.setReadTimeout(90000);//90s=3min
            //发送请求
            connection.connect();
            if (200 == connection.getResponseCode()) {
                System.out.println("code: " + connection.getResponseCode() + " message: " + connection.getResponseMessage());
                inputStream = connection.getInputStream();
                //inputStream输出string（utf-8且加换行）
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                StringBuffer stringBuffer = new StringBuffer();
                String tmp;
                while ((tmp = bufferedReader.readLine()) != null) {
                    stringBuffer.append(tmp);
                    stringBuffer.append("\r\n");
                }
                return stringBuffer.toString();
            } else {
                logger.error("请求失败！");
                logger.error("code: " + connection.getResponseCode() + "\nmessage: " + connection.getResponseMessage());
                return "http error!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("reason: " + e.getCause());
            logger.error("message: " + e.getMessage());
            return "http error!";
        } finally {
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("reason: " + e.getCause());
                    logger.error("message: " + e.getMessage());
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("reason:  " + e.getCause());
                    logger.error("message:  " + e.getMessage());
                }
            }
            connection.disconnect(); //关闭连接
        }
    }
}
