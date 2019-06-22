package cn.xyvideo.sso.model;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Data
public class Role extends EntityBase {
    private String code;
    private String name;

    public Role(){
        super();
    }

    public Role(String code, String name) {
        super();
        this.code = code;
        this.name = name;
    }
}
