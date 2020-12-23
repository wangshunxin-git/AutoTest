package com.course.model;

import lombok.Data;

/**
 * @Author: Wangsx
 * @Date: 2020/12/22 下午4:20
 */
@Data
public class AddUserCase {
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
    private String expected;
}
