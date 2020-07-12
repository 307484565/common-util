package com.zt.util.test.http;

import com.zt.util.CommonUtilApplicationTest;
import com.zt.util.http.HttpUtil;
import com.zt.util.vo.Student;
import org.junit.Test;

import java.util.HashMap;

public class HttpUtilTest extends CommonUtilApplicationTest {

    /**
     * get请求 字符串响应
     */
    @Test
    public void getForString() {
        String response = HttpUtil.buildGet("http://localhost:8080/rest/get/{id}/{name}", 1, "zt")
                .addHeader("header1", "value1")
                .addQueryParam("id", "1").addQueryParam("name", "zt")
                .setReadTimeout(5000)
                .setConnectTimeout(5000)
                .execute();
        System.out.println("响应=" + response);
    }


    /**
     * get请求 返回指定类
     */
    @Test
    public void getForObject() {
        Student student = HttpUtil.buildGet("http://localhost:8080/rest/get").execute(Student.class);
        System.out.println("响应=" + student);
    }

    /**
     * post json请求 字符串响应
     */
    @Test
    public void postJsonForString() {
        String execute = HttpUtil.buildJsonPost("http://localhost:8080/rest/post/{v1}/{v2}", 1, 2)
                .addHeader("user-agent", "chrome")
                .setBody("this is request body")
                .execute();
        System.out.println("响应=" + execute);
    }

    /**
     * post 表单请求 字符串响应
     */
    @Test
    public void postFormForString() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("age", 18);
        params.put("gender", "男");
        String execute = HttpUtil.buildFormPost("http://localhost:8080/rest/post/{v1}/{v2}", 1, 2)
                .addHeader("user-agent", "chrome")
                .addParam("name", "张三")
                .addParams(params)
                .addParams(new Student())
                .execute();

        System.out.println("响应=" + execute);
    }

}
