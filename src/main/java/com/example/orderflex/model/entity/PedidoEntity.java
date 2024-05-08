package com.example.orderflex.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_logged_id")
    private Long ClientLoggedId;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_username")
    private String clientUsername;

    @Column(name = "product_name")
    private String ProductName;

    @Column(name = "price")
    private BigDecimal price;

}
