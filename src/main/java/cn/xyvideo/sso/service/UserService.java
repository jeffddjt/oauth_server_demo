package cn.xyvideo.sso.service;

import cn.xyvideo.sso.model.Role;
import cn.xyvideo.sso.model.UserInfo;
import cn.xyvideo.sso.repository.RoleRepository;
import cn.xyvideo.sso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

        if(!this.userRepository.existsByUsername("admin")) {
            UserInfo user = new UserInfo();
            user.setUsername("admin");
            user.setPassword(this.passwordEncode().encode("admin"));
            Role role = null;
            if(!this.roleRepository.existsByName("ROLE_ADMIN")) {
                role = new Role();
                role.setName("ROLE_ADMIN");
                role = this.roleRepository.save(role);
            }else{
                role=this.roleRepository.findByName("ROLE_ADMIN");
            }
            user.setRoles(Arrays.asList(role));
            this.userRepository.save(user);
        }
    }

    public List<UserInfo> getAll() {
        return this.userRepository.findAll();
    }
    public Page<UserInfo> getAllPager(int pageNo,int pageSize){
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(pageNo-1,pageSize,sort);
        return this.userRepository.findAll(pageable);
    }

    public Object add(UserInfo userInfo) {
        userInfo.setPassword(this.passwordEncode().encode(userInfo.getPassword()));
        return this.userRepository.save(userInfo);

    }
}
