package com.course.testNG.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Author: Wangsx
 * @Date: 2020/11/26 下午3:55
 * 参数化测试-DateProvider参数化
 */
public class DataProviderTest {
    @Test(dataProvider = "date")
    public void testDateProvider(String name,int age){
        System.out.println("name =" + name +"; age="+ age);
    }

    @DataProvider(name="date")
    public Object[] [] providerDate(){
        Object[] [] o = new Object[][]{
                 {"zhangsan",10},
                 {"lisi",20},
                 {"wangwu",30}
        };
        return o;
    }

    //通过方法名来传递
    @Test(dataProvider = "methodDate")
    public void test1(String name,int age){
        System.out.println("test1方法 name="+name+ ";age="+age);
    }
    @Test(dataProvider = "methodDate")
    public void test2(String name,int age){
        System.out.println("test2方法 name="+name+ ";age="+age);
    }

    @DataProvider(name="methodDate")
    public Object [] [] methodDateTest(Method method){
        Object[] [] result=null;

        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",25}
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu",50},
                    {"zhaoliu",60}
            };
        }
        return result;
    }
}
