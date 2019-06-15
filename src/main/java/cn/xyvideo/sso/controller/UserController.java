package cn.xyvideo.sso.controller;

import cn.xyvideo.sso.model.UserInfo;
import cn.xyvideo.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("me")
    public Principal me(Principal principal){
        return principal;
    }

    @PostMapping("add")
    public Object addUser(UserInfo userInfo){
        return this.userService.add(userInfo);
    }
}
