package com.example.orderflex.rest.controller;

import com.example.orderflex.exception.CnpjAlreadyExistsException;
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
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoDTO save(@RequestBody @Valid PedidoDTO pedidoDTO) throws NotFoundClientException, CnpjAlreadyExistsException {
        return service.saveRequest(pedidoDTO);

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDTO> list(){
        return service.listRequests();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ("id") Long id)throws NotFoundClientException{
        service.deleteRequest(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PedidoDTO update(@PathVariable ("id") Long id,@RequestBody @Valid PedidoDTO pedidoDTO)throws NotFoundClientException{
        return service.updateRequest(id,pedidoDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PedidoDTO patchUpdate(@PathVariable ("id") Long id, @RequestBody @Valid PedidoDTO pedidoDTO)throws NotFoundClientException{
        return service.patchRequest(id, pedidoDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PedidoEntity> getById(@PathVariable ("id") Long id)throws NotFoundClientException{
        return service.listById(id);
    }
}
