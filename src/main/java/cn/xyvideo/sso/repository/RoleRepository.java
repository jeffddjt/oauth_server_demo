package cn.xyvideo.sso.repository;

import cn.xyvideo.sso.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role,Long> {
    boolean existsByName(@Param(value = "name") String name);
    Role findByName(String name);
}
