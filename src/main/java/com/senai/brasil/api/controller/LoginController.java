package com.senai.brasil.api.controller;

import com.senai.brasil.api.assembler.PessoaAssembler;
import com.senai.brasil.api.model.LoginModel;
import com.senai.brasil.domain.model.AuthenticationResponse;
import com.senai.brasil.domain.model.Pessoa;
import com.senai.brasil.security.ImplementsUserDetailsService;
import com.senai.brasil.security.JWTUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private AuthenticationManager authenticationManager;
    private ImplementsUserDetailsService implementsUserDetailsService;
    private JWTUtil jwtUtil;
    private PessoaAssembler pessoaAssembler;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginModel loginModel) throws Exception {
        Pessoa pessoa = pessoaAssembler.toEntityLogin(loginModel);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(pessoa.getUsername(), pessoa.getPassword())
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("Usuario ou senha inválido", ex);
        }

        final UserDetails userDetails = implementsUserDetailsService.loadUserByUsername(
                pessoa.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt, pessoaAssembler.toModelUser(pessoa)));
    }

}
