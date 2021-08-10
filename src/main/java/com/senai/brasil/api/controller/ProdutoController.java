package com.senai.brasil.api.controller;

import com.senai.brasil.api.model.ProdutoModel;
import com.senai.brasil.api.model.input.ProdutoInput;
import com.senai.brasil.domain.model.Produto;
import com.senai.brasil.domain.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel cadastrarProduto(@RequestBody ProdutoInput produtoInput) {
        return produtoService.cadastrarProduto(produtoInput);
    }


    @DeleteMapping("/deletarproduto/{produtoCodigo}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable int produtoCodigo) {
        return produtoService.excluirProduto(produtoCodigo);
    }

    @GetMapping("/listar")
    public List<ProdutoModel> listarTodos() {
        return produtoService.listarTodos();
    }

}
