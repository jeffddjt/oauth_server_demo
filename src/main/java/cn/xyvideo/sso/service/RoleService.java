package cn.xyvideo.sso.service;

import cn.xyvideo.sso.model.Role;
import cn.xyvideo.sso.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {


    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getList(){
        return this.roleRepository.findAll();
    }
}
