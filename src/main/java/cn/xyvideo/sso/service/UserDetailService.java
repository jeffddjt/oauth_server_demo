package cn.xyvideo.sso.service;

import cn.xyvideo.sso.model.Role;
import cn.xyvideo.sso.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = this.userService.getUserByName(username);
        if(userInfo==null)
            throw new UsernameNotFoundException("用户名或密码不正确!");

        List<GrantedAuthority> authorities = new ArrayList<>();
        if(userInfo.getRole()!=null)
            authorities.add(new SimpleGrantedAuthority(userInfo.getRole().getCode()));


        User user=new User(userInfo.getUsername(),userInfo.getPassword(),authorities);
        return user;
    }
}
