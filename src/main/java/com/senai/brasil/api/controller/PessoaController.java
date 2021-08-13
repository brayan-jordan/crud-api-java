package com.senai.brasil.api.controller;

import com.senai.brasil.api.model.PessoaModel;
import com.senai.brasil.api.model.input.PessoaInput;
import com.senai.brasil.domain.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

}
