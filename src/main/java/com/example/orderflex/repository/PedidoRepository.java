package com.example.orderflex.repository;

import com.example.orderflex.model.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    PedidoEntity findByClientUsername(String username);
}
