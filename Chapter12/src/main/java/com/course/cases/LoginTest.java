package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Author: Wangsx
 * @Date: 2020/12/22 下午5:52
 */
public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备工作，准备HttpClient对象")
    public void beforeTest(){
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);

        TestConfig.defaultHttpClient = new DefaultHttpClient();

    }
    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        // 发送请求
        String result = getResult(loginCase);
        // 验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    @Test(groups = "loginFalse", description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        // 发送请求
        String result = getResult(loginCase);
        // 验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    private String getResult(LoginCase loginCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());

//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("userName", loginCase.getUserName()));
//        nvps.add(new BasicNameValuePair("password", loginCase.getPassword()));
//        post.setEntity(new UrlEncodedFormEntity(nvps));

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        String result;

//        TestConfig.httpClient = HttpClients.createDefault();
//        TestConfig.defaultHttpClient = HttpClients.custom().setDefaultCookieStore(TestConfig.store).build();
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);


//        CloseableHttpResponse response = TestConfig.httpClient.execute(post);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();
//
//        HttpClientContext context = HttpClientContext.create();
//        context.setCookieStore(TestConfig.store);

        //TestConfig.store = TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        return result;
    }
}
