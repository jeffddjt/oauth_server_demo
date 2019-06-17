package cn.xyvideo.sso.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserInfo extends EntityBase {

    private String username;
    private String password;
    private String name;
    private String email;
    private String telno;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

}
