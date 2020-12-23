package com.course.model;

import lombok.Data;

/**
 * @Author: Wangsx
 * @Date: 2020/12/22 下午4:29
 */
@Data
public class LoginCase {
    private int id;
    private String userName;
    private String password;
    private String expected;
}
