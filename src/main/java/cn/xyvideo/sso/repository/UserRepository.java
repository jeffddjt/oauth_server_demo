package cn.xyvideo.sso.repository;

import cn.xyvideo.sso.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUsername(String username);
    boolean existsByUsername(String username);
}
