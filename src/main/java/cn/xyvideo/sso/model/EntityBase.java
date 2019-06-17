package cn.xyvideo.sso.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class EntityBase {
    @Id
    @GeneratedValue
    private long id;
}
