package com.example.orderflex.service;

import com.example.orderflex.exception.CnpjAlreadyExistsException;
import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.dto.PedidoDTO;
import com.example.orderflex.model.entity.PedidoEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    PedidoDTO saveRequest(PedidoDTO pedidoDTO) throws NotFoundClientException, CnpjAlreadyExistsException;
    PedidoDTO updateRequest(Long id, PedidoDTO pedidoDTO)throws NotFoundClientException;
    List<PedidoDTO> listRequests();
    void deleteRequest(Long id)throws NotFoundClientException;
    PedidoDTO patchRequest(Long id, PedidoDTO pedidoDTO)throws NotFoundClientException;
    List<PedidoEntity> listById(Long clientId)throws NotFoundClientException;
}
