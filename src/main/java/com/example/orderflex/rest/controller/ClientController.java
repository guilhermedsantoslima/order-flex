package com.example.orderflex.rest.controller;

import com.example.orderflex.exception.CnpjAlreadyExistsException;
import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.dto.ClientDTO;
import com.example.orderflex.model.entity.ClientEntity;
import com.example.orderflex.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO saveClient(@RequestBody @Valid ClientDTO clientDTO)throws CnpjAlreadyExistsException {
       return service.saveClient(clientDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDTO> listClients(){
        return service.getAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ClientEntity> listById(@PathVariable("id")Long id)throws NotFoundClientException {
        return service.getById(id);
    }
}
