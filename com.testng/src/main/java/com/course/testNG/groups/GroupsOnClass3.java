package com.course.testNG.groups;

import org.testng.annotations.Test;

/**
 * @Author: Wangsx
 * @Date: 2020/11/25 下午5:11
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("GroupsOnClass3中的teacher1运行");
    }
    public void teacher2(){
        System.out.println("GroupsOnClass3中的teacher2运行");
    }

}
