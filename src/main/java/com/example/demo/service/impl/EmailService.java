package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/*
* 用于发送邮件的服务类
* */
@Service
public class EmailService  {
    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void sendEmail(String to){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        //邮件发送人
        mailMessage.setFrom(from);
        //邮件接收人
        mailMessage.setTo(to);
        //邮件主题
        mailMessage.setSubject("欢迎注册");
        //邮件内容
        mailMessage.setText("欢迎欢迎注册");
        //发送邮件
        mailSender.send(mailMessage);
    }

}
