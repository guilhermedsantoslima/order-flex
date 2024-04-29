package com.example.orderflex.service;

import com.example.orderflex.exception.CnpjAlreadyExistsException;
import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.dto.ClientDTO;
import com.example.orderflex.model.entity.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientDTO saveClient(ClientDTO clientDTO)throws CnpjAlreadyExistsException;
    List<ClientDTO> getAll();
    Optional<ClientEntity> getById(Long id) throws NotFoundClientException;
}
