package cn.xyvideo.sso.repository;

import cn.xyvideo.sso.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    boolean existsByName(String name);
    Role findByName(String name);
}
