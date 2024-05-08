package com.example.orderflex.service.impl;

import com.example.orderflex.exception.CnpjAlreadyExistsException;
import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.dto.ClientDTO;
import com.example.orderflex.model.dto.PedidoDTO;
import com.example.orderflex.model.entity.ClientEntity;
import com.example.orderflex.model.entity.LoginEntity;
import com.example.orderflex.model.entity.PedidoEntity;
import com.example.orderflex.repository.ClientRepository;
import com.example.orderflex.repository.LoginRepository;
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
    private LoginRepository loginRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public PedidoDTO saveRequest(PedidoDTO pedidoDTO) throws NotFoundClientException, CnpjAlreadyExistsException {
        LoginEntity loginEntity = loginRepository.findByClientId(pedidoDTO.getClient_id());
        if (loginEntity == null) {
            throw new NotFoundClientException();
        }

        ClientEntity clientEntity = clientRepository.findByCnpj(pedidoDTO.getCnpj());
        if (clientEntity.getCnpj() == pedidoDTO.getCnpj()) {
            throw new CnpjAlreadyExistsException();
        } else if (clientEntity == null) {
            throw new NotFoundClientException();
        }

        PedidoEntity pedidoEntity = new PedidoEntity();

        pedidoEntity.setClientLoggedId(loginEntity.getClientId());
        pedidoEntity.setClientName(clientEntity.getName());
        pedidoEntity.setClientUsername(loginEntity.getUsername());
        pedidoEntity.setProductName(pedidoDTO.getProductName());
        pedidoEntity.setPrice(pedidoDTO.getPrice());

        pedidoRepository.save(pedidoEntity);

        return pedidoDTO;
    }


    @Override
    public PedidoDTO updateRequest(Long id, PedidoDTO pedidoDTO) throws NotFoundClientException{
        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(id);

        if(!pedidoEntity.isPresent()){
           throw new NotFoundClientException();
        }
        pedidoEntity.get().setProductName(pedidoDTO.getProductName());
        pedidoEntity.get().setPrice(pedidoDTO.getPrice());

        pedidoRepository.save(pedidoEntity.get());

        return pedidoDTO;
    }

    @Override
    public List<PedidoDTO> listRequests() {
        List<PedidoEntity> pedidoEntities = pedidoRepository.findAll();
        List<PedidoDTO> pedidoDTOS = new ArrayList<>();
        List<LoginEntity> loginEntities = loginRepository.findAll();

        pedidoEntities.forEach(p->{
             PedidoDTO pedidoDTO = new PedidoDTO();

             pedidoDTO.setClient_id(p.getClientLoggedId());
             pedidoDTO.setClientName(p.getClientName());
             pedidoDTO.setClientUsername(p.getClientUsername());
             pedidoDTO.setProductName(p.getProductName());
             pedidoDTO.setPrice(p.getPrice());

             pedidoDTOS.add(pedidoDTO);
        });
        return pedidoDTOS;
    }

    @Override
    public void deleteRequest(Long id) throws NotFoundClientException{
        pedidoRepository.deleteById(id);
    }

    @Override
    public PedidoDTO patchRequest(Long id, PedidoDTO pedidoDTO) throws NotFoundClientException {
        Optional<PedidoEntity> pedidos = pedidoRepository.findById(id);

        if (!pedidos.isPresent()) {
            throw new NotFoundClientException();
        }

        PedidoEntity pedidoEntity = pedidos.get();

        if (pedidoDTO.getProductName() != null) {
            pedidoEntity.setProductName(pedidoDTO.getProductName());
        }

        if (pedidoDTO.getPrice() != null) {
            pedidoEntity.setPrice(pedidoDTO.getPrice());
        }

        pedidoRepository.save(pedidoEntity);

        return pedidoDTO;
    }

    @Override
    public Optional<PedidoEntity> listById(Long id) throws NotFoundClientException {
        Optional<PedidoEntity> pedido = pedidoRepository.findById(id);

        if(!pedido.isPresent()){
            throw new NotFoundClientException();
        }

        return pedidoRepository.findById(id);
    }

}
