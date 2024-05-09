package com.example.orderflex.rest.controller;

import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.dto.PedidoDTO;
import com.example.orderflex.model.entity.PedidoEntity;
import com.example.orderflex.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoDTO salvar(@RequestBody @Valid PedidoDTO pedidoDTO){
        return service.salvarPedido(pedidoDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDTO> getAll(){
        return service.listarPedidos();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PedidoEntity> getById(@PathVariable ("id") Long id)throws NotFoundClientException{
        return service.listarPeloId(id);
    }
}
