package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @Author: Wangsx
 * @Date: 2020/12/22 下午4:58
 * 对应5个接口
 */
public class TestConfig {
    public static String loginUrl;
    public static String updateUserInfoUrl;
    public static String addUserUrl;
    public static String getUserInfoUrl;
    public static String getUserListUrl;

    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore store;

    // DefaultHttpClient deprecated 替换
    //public static DefaultHttpClient defaultHttpClient;
    //    public static HttpClient defaultHttpClient;
//    public static HttpClientBuilder httpClientBuilder;
    //public static CookieStore store;

}
