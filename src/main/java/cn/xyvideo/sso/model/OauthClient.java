package cn.xyvideo.sso.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class OauthClient extends EntityBase {
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
    private String grantType;
    private String scope;


}
