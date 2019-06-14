package cn.xyvideo.sso.controller;

import cn.xyvideo.sso.model.UserInfo;
import cn.xyvideo.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){
        List<UserInfo> userList = this.userService.getAll();
        model.addAttribute("userList",userList);
        return "index";
    }
}
