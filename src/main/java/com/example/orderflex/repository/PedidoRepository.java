package com.example.orderflex.repository;

import com.example.orderflex.model.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    PedidoEntity findByClientUsername(String username);

    List<PedidoEntity> findByClientLoggedId(Long clientLoggedId);
}
