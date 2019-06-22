package cn.xyvideo.sso.controller;

import cn.xyvideo.sso.model.Role;
import cn.xyvideo.sso.model.UserInfo;
import cn.xyvideo.sso.service.RoleService;
import cn.xyvideo.sso.service.UserService;
import cn.xyvideo.sso.utils.XYResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping("manage")
    public String index(Model model){
        List<Role> roles=this.roleService.getList();
        model.addAttribute("roles",roles);
        return "role_management";
    }

    @PostMapping("delete")
    @ResponseBody
    public XYResult delete(@RequestParam(name = "id",defaultValue = "0") long id){
        if(id==0){
            return new XYResult(0,"参数不正确!");
        }

        this.roleService.deleteById(id);
        return new XYResult(1,"删除成功!");
    }

    @GetMapping("add")
    public String add(){
        return "add_role";
    }
    @PostMapping("add")
    public Object add(Role role){
        Role r = this.roleService.add(role);
        return "redirect:/role/manage";
    }

    @GetMapping("modify")
    public String modify(@RequestParam(name = "id",defaultValue = "0") long id,Model model){
        model.addAttribute("role",this.roleService.getById(id));
        return "modi_role";
    }

    @PostMapping("modify")
    public String modify(Role role){
        this.roleService.modify(role);
        return "redirect:/role/manage";
    }

    @PostMapping("getMember")
    @ResponseBody
    public List<UserInfo> getMember(@RequestParam(name = "id",defaultValue = "0") long id){
        Role role=this.roleService.getById(id);
        List<UserInfo> members = this.userService.getAllByRoleId(role.getId());
        return members;

    }
}
