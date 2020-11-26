package com.course.testNG;

import org.testng.annotations.Test;

/**
 * @Author: Wangsx
 * @Date: 2020/11/25 下午6:22
 * 依赖测试
 */
public class DependTest {
    @Test
    public void test1(){
        System.out.println("run test1");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("run test2");
    }
}
