package com.senai.brasil.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PessoaInput {

    @Size(max = 50)
    @Valid
    @NotBlank
    String nome;

    @Email
    @Size(max = 100)
    @NotBlank
    @Valid
    String email;

    String senha;

}
