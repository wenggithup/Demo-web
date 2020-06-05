package com.example.demo.service;

import com.github.pagehelper.PageInfo;

public interface UserSerivce {
    String login(String username,String password);

    void addUser(String username, String email, Integer cellphone, String password);

    PageInfo showList(Integer page,Integer size);
}
