package com.course.model;

import lombok.Data;

/**
 * @Author: Wangsx
 * @Date: 2020/12/22 下午4:32
 */
@Data
public class UpdateUserInfoCase {
    private int id;
    private int userId;
    private String userName;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
    private String expected;
}
