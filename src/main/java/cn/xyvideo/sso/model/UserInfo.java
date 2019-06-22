package cn.xyvideo.sso.model;

import jdk.nashorn.internal.ir.annotations.Ignore;
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
    @Transient
    private Role role;
    private long roleId;
}
