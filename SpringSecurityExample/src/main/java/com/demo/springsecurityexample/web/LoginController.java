package com.demo.springsecurityexample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(){
        System.out.println("This code is called from the login controller");
        return "loginPage";
    }
}
