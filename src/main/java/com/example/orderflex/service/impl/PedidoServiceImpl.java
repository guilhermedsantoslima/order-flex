package com.example.orderflex.service.impl;

import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.dto.PedidoDTO;
import com.example.orderflex.model.entity.PedidoEntity;
import com.example.orderflex.repository.PedidoRepository;
import com.example.orderflex.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository repository;

    @Override
    public PedidoDTO salvarPedido(PedidoDTO pedidoDTO) {
        PedidoEntity pedido = new PedidoEntity();

        pedido.setNome(pedidoDTO.getNome());
        pedido.setNomeProduto(pedidoDTO.getNomeProduto());
        pedido.setPreco(pedidoDTO.getPreco());

        repository.save(pedido);

        return pedidoDTO;
    }

    @Override
    public List<PedidoDTO> listarPedidos() {
        List<PedidoEntity> pedidoEntities = repository.findAll();
        List<PedidoDTO> pedidoDTOS = new ArrayList<>();

        pedidoEntities.forEach(p ->{
            PedidoDTO pedidoDTO = new PedidoDTO();

            pedidoDTO.setNome(p.getNome());
            pedidoDTO.setNomeProduto(p.getNomeProduto());
            pedidoDTO.setPreco(p.getPreco());

            pedidoDTOS.add(pedidoDTO);
        });

        return pedidoDTOS;
    }

    @Override
    public Optional<PedidoEntity> listarPeloId(Long id)throws NotFoundClientException {
        Optional<PedidoEntity>pedido = repository.findById(id);

        if(!pedido.isPresent()){
            throw new NotFoundClientException();
        }

        return repository.findById(id);
    }
}
