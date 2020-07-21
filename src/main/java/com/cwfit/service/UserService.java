package com.cwfit.service;

import com.cwfit.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/5/10 - 19:07
 */
@Repository
@Mapper
public interface UserService {

    User queryUserByName(String name);

    List<User> queryUser();

    int addUser(User user);
}
