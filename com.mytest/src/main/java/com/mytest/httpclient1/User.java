package com.mytest.httpclient1;

/**
 * @Author: Wangsx
 * @Date: 2020/12/22 下午12:02
 */
public class User {
    private String name;
    private String job;
    public User() {
        super();
    }
    public User(String name, String job) {
        super();
        this.name = name;
        this.job = job;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

}
