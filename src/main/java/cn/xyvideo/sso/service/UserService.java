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
        UserInfo user=this.userRepository.findByUsername(username);
        if(user!=null&&user.getRoleId()!=0){
            user.setRole(this.roleRepository.findById(user.getRoleId()).get());
        }
        return user;
    }

    public void init() {

        if(!this.userRepository.existsByUsername("admin")) {
            UserInfo user = new UserInfo();
            user.setUsername("admin");
            user.setPassword(this.passwordEncode().encode("admin"));
            user.setName("管理员");
            user.setTelno("13888888888");
            user.setEmail("mail@email.com");
            Role role = null;
            if(!this.roleRepository.existsByCode("ROLE_ADMIN")) {
                role = new Role("ROLE_ADMIN","管理员");
                role = this.roleRepository.save(role);
            }else{
                role=this.roleRepository.findByCode("ROLE_ADMIN");
            }
            user.setRoleId(role.getId());
            this.userRepository.save(user);
        }
    }
    public List<UserInfo> getAll() {
        List<UserInfo> userInfos = this.userRepository.findAll();
        for(UserInfo user : userInfos){
            if(user!=null&&user.getRoleId()!=0){
                user.setRole(this.roleRepository.findById(user.getRoleId()).get());
            }
        }
        return userInfos;
    }
    public Page<UserInfo> getAllPager(int pageNo,int pageSize){
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(pageNo-1,pageSize,sort);
        Page<UserInfo> userInfos = this.userRepository.findAll(pageable);
        for(UserInfo user : userInfos.getContent()){
            if(user!=null&&user.getRoleId()!=0){
                user.setRole(this.roleRepository.findById(user.getRoleId()).get());
            }
        }
        return userInfos;
    }

    public Object add(UserInfo userInfo) {
        userInfo.setPassword(this.passwordEncode().encode(userInfo.getPassword()));
        return this.userRepository.save(userInfo);

    }

    public UserInfo getById(long id) {
        UserInfo user=this.userRepository.findById(id).get();
        if(user!=null&&user.getRoleId()!=0){
            user.setRole(this.roleRepository.findById(user.getRoleId()).get());
        }

        return user;
    }

    public void modifyUser(UserInfo userInfo) {
        UserInfo old = this.userRepository.findById(userInfo.getId()).get();
        old.setName(userInfo.getName());
        old.setTelno(userInfo.getTelno());
        old.setEmail(userInfo.getEmail());
        old.setRoleId(userInfo.getRoleId());
        if(!userInfo.getPassword().isEmpty()){
            old.setPassword(this.passwordEncode().encode(userInfo.getPassword()));
        }
        this.userRepository.saveAndFlush(old);

    }

    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public List<UserInfo> getAllByRoleId(long id){
        return this.userRepository.findAllByRoleId(id);
    }
}
