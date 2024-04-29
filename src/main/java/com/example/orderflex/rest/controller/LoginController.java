package com.example.orderflex.rest.controller;

import com.example.orderflex.exception.InvalidLoginException;
import com.example.orderflex.exception.NotFoundClientException;
import com.example.orderflex.model.entity.LoginEntity;
import com.example.orderflex.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) throws InvalidLoginException {
        String cnpj = loginData.get("cnpj");
        String senha = loginData.get("senha");

        if (service.saveLogin(cnpj, senha)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login não autorizado");
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<LoginEntity> list(){
        return service.listAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<LoginEntity> getUserById(@PathVariable("id") Long id) throws NotFoundClientException {
        return service.getById(id);
    }
}
