package cn.xyvideo.sso.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Role extends EntityBase {
    private String name;
}
