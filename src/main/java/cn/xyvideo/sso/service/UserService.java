package cn.xyvideo.sso.service;

import cn.xyvideo.sso.model.UserInfo;
import cn.xyvideo.sso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
        this.userRepository.save(user);
    }
}
