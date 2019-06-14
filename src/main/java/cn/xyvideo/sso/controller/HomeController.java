package cn.xyvideo.sso.controller;

import cn.xyvideo.sso.model.UserInfo;
import cn.xyvideo.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){

        return "index";
    }
    @GetMapping("userManage")
    public String userManage(String pageNo,Model model){

        int page = 1;
        try{
            page = Integer.parseInt(pageNo);
        }catch (Exception e) {
            page=1;
        }
        Page<UserInfo> pager = this.userService.getAllPager(page,20);
        model.addAttribute("pager",pager);
        return "user";
    }
}
