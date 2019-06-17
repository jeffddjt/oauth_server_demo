package cn.xyvideo.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.util.StringUtils;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(String error, Model model){
        if(!StringUtils.isEmpty(error))
            model.addAttribute("error","用户名或密码不正确!");
        return "login";
    }
}
