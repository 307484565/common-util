package com.zt.util.controller;

import com.zt.util.vo.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @RequestMapping("/rest/get")
    public Object get(HttpServletRequest request) throws InterruptedException {
        System.out.println("接收到请求 URL = " + request.getRequestURL().toString());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            System.out.println("header : " + name + " = " + request.getHeader(name));
        }
        System.out.println();
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> {
            System.out.println("param : " + k + " = " + v[0]);
        });
//        System.out.println("sleep 60s 测试超时时间设置");
//        Thread.sleep(60000);
        return new Student();
    }

    @RequestMapping("/rest/get/{id}/{name}")
    public Object restGet(HttpServletRequest request, @PathVariable Integer id, @PathVariable String name) throws InterruptedException {
        System.out.println("接收到请求 URL = " + request.getRequestURL().toString());
        System.out.println("id = " + id +  " name = " + name);
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            System.out.println("header : " + key + " = " + request.getHeader(key));
        }
        System.out.println();
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> {
            System.out.println("param : " + k + " = " + v[0]);
        });
//        System.out.println("sleep 60s 测试超时时间设置");
//        Thread.sleep(60000);
        return new Student();
    }

    @RequestMapping("/rest/post")
    public Object post(HttpServletRequest request) throws IOException, InterruptedException {
        System.out.println("接收到请求 URL = " + request.getRequestURL().toString());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            System.out.println("header : " + name + " = " + request.getHeader(name));
        }
        System.out.println("params:");
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> {
            System.out.println("param : " + k + " = " + v[0]);
        });
        System.out.println("body:");
        System.out.println(new BufferedReader(new InputStreamReader(request.getInputStream())).lines().collect(Collectors.joining()));
        System.out.println("sleep 60s 测试超时时间设置");
        Thread.sleep(60000);
        return new Student();
    }


}
