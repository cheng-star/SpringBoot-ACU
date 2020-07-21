package com.cwfit.mapper;

import com.cwfit.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/5/5 - 17:29
 */
//这个注解表示了这是一个mybatis的mapper类：Dao
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    User queryUserByName(String username);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
