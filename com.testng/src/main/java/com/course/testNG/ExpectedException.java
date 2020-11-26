package com.course.testNG;

import org.testng.annotations.Test;

/**
 * @Author: Wangsx
 * @Date: 2020/11/25 下午5:52
 * 什么时候会用到异常测试？？？
 * 在我们期望结果为某一个异常的时候
 * 比如：我们传了一些不合法的参数，程序抛出的异常
 * 也就是说我们的预期结果就是这个异常
 */

public class ExpectedException {
    //这个是一个测试结果会失败的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    //这是一个成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();

    }
}
