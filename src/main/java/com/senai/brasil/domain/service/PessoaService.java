package com.senai.brasil.domain.service;

import com.senai.brasil.api.assembler.PessoaAssembler;
import com.senai.brasil.api.model.PessoaModel;
import com.senai.brasil.api.model.edit.EditEmailPessoa;
import com.senai.brasil.api.model.edit.EditNomePessoa;
import com.senai.brasil.api.model.edit.EditSenhaPessoa;
import com.senai.brasil.api.model.input.PessoaInput;
import com.senai.brasil.domain.exception.NegocioException;
import com.senai.brasil.domain.model.Pessoa;
import com.senai.brasil.domain.model.Produto;
import com.senai.brasil.domain.model.RolePessoa;
import com.senai.brasil.domain.repository.PessoaRepository;
import com.senai.brasil.domain.repository.RolePessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaAssembler pessoaAssembler;
    private RolePessoaService rolePessoaService;

    public PessoaModel cadastrarPessoa(PessoaInput pessoaInput) {
        Pessoa pessoa = pessoaAssembler.toEntity(pessoaInput);
        pessoa.setSenha(new BCryptPasswordEncoder().encode(pessoa.getSenha()));
        pessoaRepository.save(pessoa);
        rolePessoaService.cadastrar(pessoa.getCodigo());
        return pessoaAssembler.toModel(pessoa);
    }

    public List<PessoaModel> listarPessoas() {
        return pessoaAssembler.toCollectionModel(pessoaRepository.findAll());
    }

    public ResponseEntity<Produto> excluirPessoa(int pessoaCodigo) {
        Pessoa pessoa = pessoaRepository.findByCodigo(pessoaCodigo);
        if (pessoa == null) {
            throw new NegocioException("Nao existe uma pessoa com esse codigo para excluir");
        }

        pessoaRepository.delete(pessoa);
        return ResponseEntity.noContent().build();
    }

    public PessoaModel editarEmailPessoa(EditEmailPessoa editEmailPessoa, int pessoaCodigo) {
        Pessoa pessoa = pessoaRepository.findByCodigo(pessoaCodigo);
        if (pessoa == null) {
            throw new NegocioException("Nao existe uma pessoa com esse codigo para editar");
        }

        pessoa.setEmail(editEmailPessoa.getEmail());
        pessoaRepository.save(pessoa);
        return pessoaAssembler.toModel(pessoa);
    }

    public PessoaModel editarSenhaPessoa(EditSenhaPessoa editSenhaPessoa, int pessoaCodigo) {
        Pessoa pessoa = pessoaRepository.findByCodigo(pessoaCodigo);
        if (pessoa == null) {
            throw new NegocioException("Nao existe uma pessoa com esse codigo para editar");
        }

        pessoa.setSenha(new BCryptPasswordEncoder().encode(editSenhaPessoa.getSenha()));
        pessoaRepository.save(pessoa);
        return pessoaAssembler.toModel(pessoa);
    }

    public PessoaModel editarNomePessoa(EditNomePessoa editNomePessoa, int pessoaCodigo) {
        Pessoa pessoa = pessoaRepository.findByCodigo(pessoaCodigo);
        if (pessoa == null) {
            throw new NegocioException("Nao existe uma pessoa com esse codigo para editar");
        }

        pessoa.setNome(editNomePessoa.getNome());
        pessoaRepository.save(pessoa);
        return pessoaAssembler.toModel(pessoa);
    }

    public String editarAdmin(Long codigo) {
        RolePessoa rolePessoa = rolePessoaService.buscar(codigo);
        rolePessoa.setRole_nome_role("ROLE_ADMIN");
        rolePessoaService.salvar(rolePessoa);
        return "Tornou usuario um admin";
    }
}
