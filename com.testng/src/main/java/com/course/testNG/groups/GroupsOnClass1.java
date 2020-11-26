package com.course.testNG.groups;

import org.testng.annotations.Test;

/**
 * @Author: Wangsx
 * @Date: 2020/11/25 下午5:08
 * 组测试中的类方法测试
 */
@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("GroupsOnClass1中的stu1运行");
    }
    public void stu2(){
        System.out.println("GroupsOnClass1中的stu2运行");
    }
}
