package com.cwfit;

import com.cwfit.mapper.UserMapper;
import com.cwfit.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootAcuApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        List<User> userList = userMapper.queryUserList();
        for (User user:userList){
            System.out.println(user);
        }
    }

    @Test
    void test2(){

        List<User> userList = userMapper.queryUserList();

        for (User user:userList){
            System.out.println(user.getUsername());
        }
    }

}
