package com.mytest.httpclient.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mytest.httpclient1.Util;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Author: Wangsx
 * @Date: 2020/12/22 上午11:43
 */
public class testNG {
    CloseableHttpClient client;
    CloseableHttpResponse response;
    HttpEntity responseBody;
    int responseCode;

    @BeforeTest
    public void setUp() {
        // 创建一个httpClient的实例
        client = HttpClients.createDefault();
    }

    @Test
    public void getTest() throws ClientProtocolException, IOException {
        String	url = "https://reqres.in/api/users?pages=2";
        // 创建一个httpGet请求实例
        HttpGet httpGet = new HttpGet(url);
        // 使用httpClient实例发送刚创建的get请求，并用httpResponse将响应接收
        response = client.execute(httpGet);
        // 从响应中提取出状态码
        responseCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(responseCode, 200, "The response code should be 200!");
        // 从响应中提取出响应主体
        responseBody = response.getEntity();
        //转为字符串
        String responseBodyString = EntityUtils.toString(responseBody,"utf-8");
        // 创建Json对象，把上面字符串序列化成Json对象
        JSONObject responseJson = JSON.parseObject(responseBodyString);
        // json内容解析
        int page = responseJson.getInteger("page"); Assert.assertEquals(page, 2,
                "The page value should be 2!");
        String firstName = Util.getValueByJPath(responseJson, "data[0]/first_name");
        Assert.assertEquals(firstName, "Michael", "The first name should be Michael!");
    }

}
