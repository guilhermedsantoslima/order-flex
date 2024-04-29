package com.example.orderflex.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    @NotEmpty(message = "{campo.name.obrigatorio}")
    private String name;

    @NotEmpty(message = "{campo.username.obrigatorio}")
    private String username;

    @NotEmpty(message = "{campo.password.obrigatorio}")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$",
    message = "{campo.password.invalido}")
    private String password;

    @NotEmpty(message = "{campo.cnpj.obrigatorio}")
    @Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})",
    message = "{campo.cnpj.invalido}")
    private String cnpj;
}
