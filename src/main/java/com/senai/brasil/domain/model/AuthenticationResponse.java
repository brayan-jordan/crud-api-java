package com.senai.brasil.domain.model;

import com.senai.brasil.api.model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthenticationResponse {

    private String jwt;
    private UsuarioModel usuario;

}
