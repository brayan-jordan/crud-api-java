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

@Repository
@Transactional
@AllArgsConstructor
public class ImplementsUserDetailsService implements UserDetailsService {

    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        if (pessoa == null) {
            throw new NegocioException("Usuario e/ou senha inválidos");
        }

        return new User(
                pessoa.getUsername(),
                pessoa.getPassword(),
                true,
                true,
                true,
                true,
                pessoa.getAuthorities()
        );
    }
}
