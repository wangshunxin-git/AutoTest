package com.course.testNG;

import org.testng.annotations.Test;

/**
 * @Author: Wangsx
 * @Date: 2020/11/27 下午1:21
 * 超时测试
 */
public class TimeOutTest {

    @Test(timeOut = 3000)//单位为毫秒值
    public void timeSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void timeFailed() throws InterruptedException {
        Thread.sleep(3000);
    }
}
