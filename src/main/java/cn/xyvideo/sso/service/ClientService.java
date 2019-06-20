package cn.xyvideo.sso.service;

import cn.xyvideo.sso.model.OauthClient;
import cn.xyvideo.sso.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public OauthClient getClientByClientId(String clientid){
        return this.clientRepository.findByClientId(clientid);
    }
    public List<OauthClient> getOauthClientByClientId(String clientid){
        return this.clientRepository.findOauthClientsByClientId(clientid);
    }
}
