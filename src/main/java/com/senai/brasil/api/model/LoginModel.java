package com.senai.brasil.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginModel {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

}
