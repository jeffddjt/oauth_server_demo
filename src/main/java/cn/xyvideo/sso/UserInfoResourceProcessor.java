package cn.xyvideo.sso;

import cn.xyvideo.sso.model.UserInfo;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserInfoResourceProcessor implements ResourceProcessor<Resource<UserInfo>> {
    @Override
    public Resource<UserInfo> process(Resource<UserInfo> resource) {
        return resource;
    }
}
