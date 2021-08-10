package com.senai.brasil.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProdutoInput {

    @Size(min = 5, max = 100)
    @NotBlank
    @Valid
    String nome;

    int quantidade;

    @NotNull
    @Valid
    double valorUnitario;

}
