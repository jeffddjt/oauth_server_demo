package cn.xyvideo.sso.config;


import cn.xyvideo.sso.model.Role;
import cn.xyvideo.sso.model.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryConfig {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer(){
        return new RepositoryRestConfigurer() {
            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
                config.exposeIdsFor(UserInfo.class, Role.class);
            }
        };
    }

}
