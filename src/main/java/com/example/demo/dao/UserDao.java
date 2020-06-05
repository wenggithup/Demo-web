package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.entity.UserLoginLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //通过username查询User对象
    User selectUserByUsername(String username);

    //新增用户
    void insertUser(User user);

    //新增日志信息
    void insertUserLoginLog(UserLoginLog userLoginLog);

    //展示日志信息
    List<UserLoginLog> selectUserLoginList();
}
