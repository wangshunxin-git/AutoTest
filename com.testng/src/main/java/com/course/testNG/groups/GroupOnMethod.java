package com.course.testNG.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @Author: Wangsx
 * @Date: 2020/11/25 下午4:46 组测试中的方法分组测试
 */
public class GroupOnMethod {

    @Test (groups = "server")
    public void test1(){
        System.out.println("这是服务端组的测试方法1111");
    }

    @Test (groups = "server")
    public void test2(){
        System.out.println("这是服务端组的测试方法2222");
    }

    @Test (groups = "client")
    public void test3(){
        System.out.println("这是客户端组的测试方法3333");
    }
    @Test (groups = "client")
    public void test4(){
        System.out.println("这是客户端组的测试方法4444");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前运行的方法");
    }
    @AfterGroups("server")
    public void afterGroupOnServer(){
        System.out.println("这是服务端组运行之后的方法");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是kehuduan组运行之前运行的方法");
    }
    @AfterGroups("client")
    public void afterGroupOnClient(){
        System.out.println("这是kehuduan组运行之后的方法");
    }
}
