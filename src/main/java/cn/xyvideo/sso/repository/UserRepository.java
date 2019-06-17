package cn.xyvideo.sso.repository;

import cn.xyvideo.sso.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;


public interface UserRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUsername(@Param(value = "username") String username);
    boolean existsByUsername(String username);
}
