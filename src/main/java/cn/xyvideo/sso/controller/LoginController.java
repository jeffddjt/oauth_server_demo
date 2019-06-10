package cn.xyvideo.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("login")
//    @ResponseBody
    public String login(){
        return "login";
    }
}
