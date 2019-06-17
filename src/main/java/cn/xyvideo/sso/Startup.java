package cn.xyvideo.sso;

import cn.xyvideo.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@SpringBootApplication
public class Startup extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Startup.class,args);
    }

    @Autowired
    private UserService userService;

    @Autowired
    public void init(){
        this.userService.init();
    }


}
