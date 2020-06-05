package com.example.demo.service.impl;


import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLoginLog;
import com.example.demo.service.UserSerivce;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserSerivce {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    public String login(String username, String password) {

        User user = userDao.selectUserByUsername(username);
        //判断用户是否合法
        if (user != null && encoder.matches(password,user.getPassword())) {
            //登录成功后，将登录数据记录并添加到日志信息中
            try {
            UserLoginLog userLoginLog=new UserLoginLog();
            userLoginLog.setUserId(user.getUserId());
            userLoginLog.setLoginTime(new Date());
            userLoginLog.setLoginIp(InetAddress.getLocalHost().toString());
            userDao.insertUserLoginLog(userLoginLog);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            return "list";
        }
        return "login";
    }

    @Override
    public void addUser(String username, String email, Integer cellphone, String password) {
        User user = userDao.selectUserByUsername(username);
        if(user!=null){
            throw new RuntimeException("用户名已注册");
        }
        User user1=new User();
        user1.setUserName(username);
        user1.setPassword(encoder.encode(password));
        user1.setCellphone(cellphone);
        user1.setCreateTime(new Date());
        userDao.insertUser(user1);
    }

    @Override
    public PageInfo showList(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<UserLoginLog> userLoginLogs = userDao.selectUserLoginList();
        return new PageInfo(userLoginLogs);
    }
}
