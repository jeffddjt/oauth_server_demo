package cn.xyvideo.sso.service;

import cn.xyvideo.sso.model.Role;
import cn.xyvideo.sso.model.UserInfo;
import cn.xyvideo.sso.repository.RoleRepository;
import cn.xyvideo.sso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncode(){
        return new BCryptPasswordEncoder();
    }

    public UserInfo getUserByName(String username){
        return this.userRepository.findByUsername(username);
    }

    public void init() {
        UserInfo user=new UserInfo();
        user.setUsername("admin");
        user.setPassword(this.passwordEncode().encode("admin"));
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        role = this.roleRepository.save(role);
        user.setRoles(Arrays.asList(role));
        this.userRepository.save(user);
    }
}
