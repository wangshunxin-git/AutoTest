package com.course.model;

import lombok.Data;

/**
 * @Author: Wangsx
 * @Date: 2020/12/22 下午3:58
 */

@Data
public class User {

    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;

    @Override
    public String toString(){
        return (
            "id"+id+","+
            "userName"+userName+","+
            "password"+password+","+
            "age"+age+","+
            "age"+age+","+
            "sex"+sex+","+
            "permission"+permission+","+
            "isDelete"+isDelete+"}"
                    );
    }

}
