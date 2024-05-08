package com.example.orderflex.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long client_id;
    private String cnpj;
    private String clientName;
    private String clientUsername;
    private String ProductName;
    private BigDecimal price;

}
