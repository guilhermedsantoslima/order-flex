package com.example.orderflex.service;

import com.example.orderflex.exception.InvalidLoginException;
import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.entity.LoginEntity;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    boolean saveLogin(String cnpj, String senha)throws InvalidLoginException;
    List<LoginEntity> listAll();
    Optional<LoginEntity> getById(Long id)throws NotFoundClientException;

}
