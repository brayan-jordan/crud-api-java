package com.senai.brasil.domain.service;

import com.senai.brasil.domain.model.RolePessoa;
import com.senai.brasil.domain.repository.RolePessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RolePessoaService {

    private RolePessoaRepository rolePessoaRepository;

    @Transactional
    public void cadastrar(int pessoaCodigo) {
        RolePessoa rolePessoa = new RolePessoa();
        rolePessoa.setPessoas_codigo(pessoaCodigo);
        rolePessoa.setRole_nome_role("ROLE_USER");

        rolePessoaRepository.save(rolePessoa);
    }

    public RolePessoa buscar(Long codigo) {
        return rolePessoaRepository.findById2(codigo);
    }

    public void salvar(RolePessoa rolePessoa) {
        rolePessoaRepository.save(rolePessoa);
    }

}
