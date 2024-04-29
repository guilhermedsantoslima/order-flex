package com.example.orderflex.repository;

import com.example.orderflex.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

     ClientEntity findByCnpj(String cnpj);
     ClientEntity findByPassword(String password);
}
