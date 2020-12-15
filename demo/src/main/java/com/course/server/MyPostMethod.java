package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Wangsx
 * @Date: 2020/12/7 下午5:08
 */
@RestController
//访问地址前要加/v1
@RequestMapping("/v1")
public class MyPostMethod {
    //cookie变量用来装我们的cookies信息
    private  static Cookie cookie;

    //用户登陆成功获取到cookies，然后在访问其他接口获取到的列表
    @RequestMapping(value = "/get/userList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,     //没有HttpServletRequest request的话，cookies是带不进来的
                              @RequestBody User u){
        User user;
        //获取cookies
        Cookie[] cookies =request.getCookies();

        //验证cookies是否合法
        for(Cookie c:cookies){
            if(c.getName() == "login"
            && c.getValue() == "true"
            && u.getUserName()=="zhangsan"
            && u.getPassword()=="123456"
            ){
                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
