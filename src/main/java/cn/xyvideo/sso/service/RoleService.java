package cn.xyvideo.sso.service;

import cn.xyvideo.sso.model.Role;
import cn.xyvideo.sso.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoleService {


    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getList(){
        return this.roleRepository.findAll();
    }

    public void init(){
        List<Role> roles=new ArrayList<>();
        if(!this.roleRepository.existsByCode("ROLE_ADMIN")) {
            roles.add(new Role("ROLE_ADMIN", "管理员"));
        }
        if(!this.roleRepository.existsByCode("ROLE_USER")) {
           roles.add(new Role("ROLE_USER", "普通用户"));
        }
        if(!roles.isEmpty()) {
            this.roleRepository.saveAll(roles);
        }
    }

    public void deleteById(long id) {
        this.roleRepository.deleteById(id);
    }

    public Role add(Role role) {
        return this.roleRepository.save(role);
    }

    public Role getById(long id) {
        return this.roleRepository.findById(id).get();
    }

    public void modify(Role role) {
        Role old = this.roleRepository.findById(role.getId()).get();
        old.setName(role.getName());
        old.setCode(role.getCode());
        this.roleRepository.saveAndFlush(old);
    }
}

