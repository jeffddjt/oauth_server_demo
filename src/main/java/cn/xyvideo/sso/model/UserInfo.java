package cn.xyvideo.sso.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class UserInfo extends EntityBase {

    private String username;
    private String password;
}
