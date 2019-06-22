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

    public List<OauthClient> getAll() {
        return this.clientRepository.findAll();
    }

    public void add(OauthClient client) {
        this.clientRepository.save(client);
    }

    public OauthClient getClientById(long id) {

        return this.clientRepository.findById(id).get();
    }

    public void deleteById(long id) {
        this.clientRepository.deleteById(id);
    }

    public void modify(OauthClient client) {
        OauthClient old = this.clientRepository.findById(client.getId()).get();
        old.setClientId(client.getClientId());
        old.setClientSecret(client.getClientSecret());
        old.setGrantType(client.getGrantType());
        old.setScope(client.getScope());
        old.setRedirectUrl(client.getRedirectUrl());
        this.clientRepository.saveAndFlush(old);
    }
}
