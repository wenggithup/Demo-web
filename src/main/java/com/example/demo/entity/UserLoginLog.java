package com.example.demo.entity;

import java.util.Date;

public class UserLoginLog {
    private Integer loginId;    //登录id
    private Integer userId;     //用户id
    private Date loginTime;     //登陆时间
    private String loginIp;     //登录ip

    public UserLoginLog(Integer loginId, Integer userId, Date loginTime, String loginIp) {
        this.loginId = loginId;
        this.userId = userId;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
    }

    public UserLoginLog() {
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
