package com.cwfit.service;

import com.cwfit.mapper.UserMapper;
import com.cwfit.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/5/10 - 19:08
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public List<User> queryUser() {
        return userMapper.queryUserList();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
