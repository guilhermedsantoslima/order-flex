package com.example.orderflex.service.impl;

import com.example.orderflex.exception.InvalidLoginException;
import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.entity.ClientEntity;
import com.example.orderflex.model.entity.LoginEntity;
import com.example.orderflex.repository.ClientRepository;
import com.example.orderflex.repository.LoginRepository;
import com.example.orderflex.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LoginRepository loginRepository;

    public boolean saveLogin(String cnpj, String senha)throws InvalidLoginException {
        ClientEntity client = clientRepository.findByCnpj(cnpj);

        if(client != null && client.getPassword().equals(senha)){
            LoginEntity loginClient = new LoginEntity();

            loginClient.setClientId(client.getId());
            loginClient.setUsername(client.getUsername());
            loginClient.setLoginTime(LocalDateTime.now());

            loginRepository.save(loginClient);
            return true;
        }
        else{
           throw new InvalidLoginException();
        }
    }

    public List<LoginEntity> listAll() {
        List<LoginEntity> loginEntities = loginRepository.findAll();
        return loginEntities;
    }

    public Optional<LoginEntity> getById(Long id)throws NotFoundClientException {
        Optional<LoginEntity> loginEntities = loginRepository.findById(id);

        if(!loginEntities.isPresent()){
            throw new NotFoundClientException();
        }
        return loginRepository.findById(id);
    }
}
