package cn.xyvideo.sso.repository;

import cn.xyvideo.sso.model.OauthClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<OauthClient,Long> {
    OauthClient findByClientId(String clientid);
    List<OauthClient> findOauthClientsByClientId(String clientid);
}
