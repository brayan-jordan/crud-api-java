package com.senai.brasil.api.model.edit;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EditEmailPessoa {

    @Email
    @Size(min = 10)
    private String email;

}
