package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author: Wangsx
 * @Date: 2020/12/22 下午5:36
 */
public class DatabaseUtil {
    public static SqlSession getSqlSession() throws IOException {
        //获取配置资源文件
        Reader reader = Resources.getResourceAsReader("dataConfig.xml");

        //build出来
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //sqlSession能够执行配置文件中的sql语句
        SqlSession sqlSession = factory.openSession();

        return sqlSession;
    }
}
