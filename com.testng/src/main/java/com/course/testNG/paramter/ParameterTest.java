package com.course.testNG.paramter;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author: Wangsx
 * @Date: 2020/11/26 下午1:04
 * 参数化测试,通过xml进行参数化
 */

public class ParameterTest {

    @Test
    @Parameters({"name","age"})
    public void paramTest(String name,int age){
        System.out.println("name= " + name + "; age = " + age);

    }
}
