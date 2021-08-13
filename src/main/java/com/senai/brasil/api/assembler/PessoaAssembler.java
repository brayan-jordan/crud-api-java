package com.senai.brasil.api.assembler;

import com.senai.brasil.api.model.LoginModel;
import com.senai.brasil.api.model.PessoaModel;
import com.senai.brasil.api.model.UsuarioModel;
import com.senai.brasil.api.model.input.PessoaInput;
import com.senai.brasil.domain.model.Pessoa;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PessoaAssembler {

    private ModelMapper modelMapper;

    public Pessoa toEntity(PessoaInput pessoaInput) {
        return modelMapper.map(pessoaInput, Pessoa.class);
    }

    public PessoaModel toModel(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaModel.class);
    }

    public List<PessoaModel> toCollectionModel(List<Pessoa> pessoas) {
        return pessoas.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Pessoa toEntityLogin(LoginModel loginModel) {
        return modelMapper.map(loginModel, Pessoa.class);
    }

    public UsuarioModel toModelUser(Pessoa pessoa) {
        return modelMapper.map(pessoa, UsuarioModel.class);
    }
}
