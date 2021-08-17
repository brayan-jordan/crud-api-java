package com.senai.brasil.security;

import com.senai.brasil.domain.exception.NegocioException;
import com.senai.brasil.domain.model.Pessoa;
import com.senai.brasil.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    private PessoaRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pessoa usuario = usuarioRepository.findByEmail(email);

        if(usuario == null){
            throw new NegocioException("Usuário ou senha inválido.");
        }

        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                true,
                true,
                true,
                true,
                usuario.getAuthorities()
        );
    }
}
