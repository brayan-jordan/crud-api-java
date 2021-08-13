package com.senai.brasil.domain.service;

import com.senai.brasil.api.assembler.PessoaAssembler;
import com.senai.brasil.api.model.PessoaModel;
import com.senai.brasil.api.model.input.PessoaInput;
import com.senai.brasil.domain.model.Pessoa;
import com.senai.brasil.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaAssembler pessoaAssembler;

    public PessoaModel cadastrarPessoa(PessoaInput pessoaInput) {
        Pessoa pessoa = pessoaAssembler.toEntity(pessoaInput);
        pessoaRepository.save(pessoa);
        return pessoaAssembler.toModel(pessoa);
    }

    public List<PessoaModel> listarPessoas() {
        return pessoaAssembler.toCollectionModel(pessoaRepository.findAll());
    }

}
