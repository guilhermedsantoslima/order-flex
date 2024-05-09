package com.example.orderflex.service;

import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.dto.PedidoDTO;
import com.example.orderflex.model.entity.PedidoEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    PedidoDTO salvarPedido(PedidoDTO pedidoDTO);
    List<PedidoDTO> listarPedidos();
    Optional<PedidoEntity> listarPeloId(Long id)throws NotFoundClientException;
}
