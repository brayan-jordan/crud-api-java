package com.senai.brasil.api.controller;

import com.senai.brasil.api.model.PessoaModel;
import com.senai.brasil.api.model.edit.EditEmailPessoa;
import com.senai.brasil.api.model.edit.EditNomePessoa;
import com.senai.brasil.api.model.edit.EditSenhaPessoa;
import com.senai.brasil.api.model.input.PessoaInput;
import com.senai.brasil.domain.model.Produto;
import com.senai.brasil.domain.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaModel cadastrar(@RequestBody PessoaInput pessoaInput) {
        return pessoaService.cadastrarPessoa(pessoaInput);
    }

    @GetMapping("/listar")
    public List<PessoaModel> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @DeleteMapping("/deletarpessoa/{pessoaCodigo}")
    public ResponseEntity<Produto> deletarPessoa(@PathVariable int pessoaCodigo) {
        return pessoaService.excluirPessoa(pessoaCodigo);
    }

    @PutMapping("/editarnome/{pessoaCodigo}")
    public PessoaModel editarNome(@RequestBody EditNomePessoa editNomePessoa, @PathVariable int pessoaCodigo) {
        return pessoaService.editarNomePessoa(editNomePessoa, pessoaCodigo);
    }

    @PutMapping("/editaremail/{pessoaCodigo}")
    public PessoaModel editarEmail(@RequestBody EditEmailPessoa editEmailPessoa, @PathVariable int pessoaCodigo) {
        return pessoaService.editarEmailPessoa(editEmailPessoa, pessoaCodigo);
    }

    @PutMapping("/editarsenha/{pessoaCodigo}")
    public PessoaModel editarSenha(@RequestBody EditSenhaPessoa editSenhaPessoa, @PathVariable int pessoaCodigo) {
        return pessoaService.editarSenhaPessoa(editSenhaPessoa, pessoaCodigo);
    }

    @PutMapping("/editaradmin/{pessoaCodigo}")
    public String editarAdmin(@PathVariable Long pessoaCodigo) {
        return pessoaService.editarAdmin(pessoaCodigo);
    }

}
