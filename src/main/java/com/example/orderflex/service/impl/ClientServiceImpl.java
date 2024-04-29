package com.example.orderflex.service.impl;

import com.example.orderflex.exception.CnpjAlreadyExistsException;
import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.dto.ClientDTO;
import com.example.orderflex.model.entity.ClientEntity;
import com.example.orderflex.repository.ClientRepository;
import com.example.orderflex.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;
    @Override
    public ClientDTO saveClient(ClientDTO clientDTO)throws CnpjAlreadyExistsException {
        ClientEntity clientCnpj = repository.findByCnpj(clientDTO.getCnpj());
        if (clientCnpj != null){
             throw new CnpjAlreadyExistsException();
        }

        ClientEntity clientPassword = repository.findByPassword(clientDTO.getPassword());
        if (clientPassword != null){
            throw new RuntimeException("Essa senha já existe");
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setName(clientDTO.getName());
        clientEntity.setUsername(clientDTO.getUsername());
        clientEntity.setCnpj(clientDTO.getCnpj());
        clientEntity.setPassword(clientDTO.getPassword());

        repository.save(clientEntity);

        return clientDTO;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<ClientEntity> clientEntities = this.repository.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();

        clientEntities.forEach(clientEntity -> {
             ClientDTO clientDTO = new ClientDTO();

             clientDTO.setName(clientEntity.getName());
             clientDTO.setUsername(clientEntity.getUsername());
             clientDTO.setCnpj(clientEntity.getCnpj());
             clientDTO.setPassword(clientEntity.getPassword());

             clientDTOS.add(clientDTO);
        });
        return clientDTOS;
    }

    @Override
    public Optional<ClientEntity> getById(Long id) throws NotFoundClientException {
        Optional<ClientEntity> client = repository.findById(id);

        if (!client.isPresent()){
            throw new NotFoundClientException();
        }
        return repository.findById(id);
    }

}
