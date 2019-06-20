package cn.xyvideo.sso.service;

import cn.xyvideo.sso.model.OauthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class ClientDetailService implements ClientDetailsService {

    @Autowired
    private ClientService clientService;


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OauthClient client =  clientService.getClientByClientId(clientId);
        if(client==null){
            throw new ClientRegistrationException("clientId无效!");
        }
        BaseClientDetails clientDetails = new BaseClientDetails();
        clientDetails.setClientId(client.getClientId());
        clientDetails.setClientSecret(this.passwordEncoder().encode(client.getClientSecret()));
        clientDetails.setRegisteredRedirectUri(new HashSet<>(Arrays.asList(client.getRedirectUrl().split(","))));
        clientDetails.setAuthorizedGrantTypes(Arrays.asList(client.getGrantType().split(",")));
        clientDetails.setScope(Arrays.asList(client.getScope().split(",")));
        clientDetails.setAutoApproveScopes(Arrays.asList("read","write"));
        return clientDetails;
    }

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
