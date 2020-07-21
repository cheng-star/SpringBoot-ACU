package com.cwfit.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yeyike
 * @date 2020/5/5 - 17:20
 */
@Data
@NoArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
    private char sex;
    private String perms;
    private String record;

    public User(String username, String password, char sex) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        perms = "user:add";
    }
}
