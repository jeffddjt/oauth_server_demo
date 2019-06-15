package cn.xyvideo.sso.controller;

import cn.xyvideo.sso.model.Role;
import cn.xyvideo.sso.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("getlist")
    public List<Role> getList(){
        return roleService.getList();
    }
}
