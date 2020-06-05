package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class User{
    private Integer userId;         //用户ID

    private String userName;        //用户账号

    private String email;           //用户邮箱

    private Integer cellphone;      //用户手机

    private String password;        //用户密码

    private String salt;            //

    private Integer state;          //用户状态

    private Date createTime;        //创建时间

    public User(Integer userId, String userName, String email, Integer cellphone, String password, String salt, Integer state, Date createTime) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.cellphone = cellphone;
        this.password = password;
        this.salt = salt;
        this.state = state;
        this.createTime = createTime;
    }

    public User() {
    }

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCellphone() {
        return cellphone;
    }

    public void setCellphone(Integer cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}