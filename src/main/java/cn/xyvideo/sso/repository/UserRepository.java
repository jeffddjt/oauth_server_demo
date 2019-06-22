package cn.xyvideo.sso.repository;

import cn.xyvideo.sso.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUsername(@Param(value = "username") String username);
    boolean existsByUsername(String username);

    List<UserInfo> findAllByRoleId(long id);
}
