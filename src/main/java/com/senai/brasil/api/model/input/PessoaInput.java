package com.senai.brasil.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PessoaInput {

    @Size(max = 50)
    @Valid
    @NotBlank
    String nome;

    @Size(max = 100)
    @NotBlank
    String email;

    String senha;

}
