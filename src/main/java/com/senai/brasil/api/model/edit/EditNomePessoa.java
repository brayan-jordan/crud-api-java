package com.senai.brasil.api.model.edit;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EditNomePessoa {

    @NotBlank
    @Size(min = 5)
    private String nome;

}
