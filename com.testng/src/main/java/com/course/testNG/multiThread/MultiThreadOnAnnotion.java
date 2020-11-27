package com.course.testNG.multiThread;

import org.testng.annotations.Test;

/**
 * @Author: Wangsx
 * @Date: 2020/11/27 上午11:19
 */
public class MultiThreadOnAnnotion {

    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
