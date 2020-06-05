package com.example.demo.controller;
import com.example.demo.service.UserSerivce;
import com.example.demo.service.impl.EmailService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class userController {
    @Autowired
    private UserSerivce userSerivce;

    @Autowired
    private EmailService emailService;
    /*
    * 处理登录界面get请求
    * */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showlogin() {
        return "login";
    }

    /*
     * 处理登录界面post请求
     * */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showlogin(@RequestParam String username, @RequestParam String password) {
        String login = userSerivce.login(username, password);
        return "redirect:/" + login;
    }

    /*
    * 处理注册页面get请求
    * */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister() {
        return "register";
    }

    /*
    * 处理注册页面post请求
    * */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String add(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam Integer cellphone,
                               @RequestParam String password) {
        userSerivce.addUser(username, email, cellphone, password);
        return "redirect:/login";
    }
    /*
    * 用于处理email的ajax请求
    * */
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public void sendEmial(@RequestParam String email){
        emailService.sendEmail(email);
    }

    /*
    * 用户展示用户登录记录的请求
    * */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showList(Model model,
                           @RequestParam(required = false,defaultValue ="1")Integer page,
                           @RequestParam(required = false,defaultValue ="10")Integer size){
       PageInfo users= userSerivce.showList(page,size);
       model.addAttribute("users",users);
        return "list";
    }
}