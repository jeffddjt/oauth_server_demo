package cn.xyvideo.sso.controller;

import cn.xyvideo.sso.model.UserInfo;
import cn.xyvideo.sso.service.UserService;
import cn.xyvideo.sso.utils.XYResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }

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
        return "user_management";
    }

    @GetMapping("addUser")
    public String addUser(Model model){
        model.addAttribute("action","addUser");
        return "add_user";
    }

    @PostMapping("addUser")
    public Object addUser(UserInfo userInfo){
        this.userService.add(userInfo);
        return new ModelAndView("redirect:/userManage");
    }

    @GetMapping("getall")
    @ResponseBody
    public Object getAll(){
        return this.userService.getAll();
    }


    @GetMapping("modifyUser")
    public String modifyUser(@RequestParam(name = "id",defaultValue = "0") long id,Model model){
        UserInfo userInfo = this.userService.getById(id);
        model.addAttribute("user",userInfo);
        return "modi_user";
    }

    @PostMapping("modifyUser")
    public ModelAndView modifyUser(UserInfo userInfo){
        this.userService.modifyUser(userInfo);
        return new ModelAndView("redirect:/userManage");
    }

    @PostMapping("deleteUser")
    @ResponseBody
    public XYResult deleteUser(@RequestParam(name = "id",defaultValue = "0") long id){
        if(id==0){
            return new XYResult(0,"参数不正确!");
        }

        this.userService.deleteUser(id);
        return new XYResult(1,"删除成功!");

    }

}
