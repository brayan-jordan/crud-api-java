package com.senai.brasil.domain.service;

import com.senai.brasil.api.assembler.ProdutoAssembler;
import com.senai.brasil.api.model.ProdutoModel;
import com.senai.brasil.api.model.input.ProdutoInput;
import com.senai.brasil.domain.model.Produto;
import com.senai.brasil.domain.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoAssembler produtoAssembler;
    private ProdutoRepository produtoRepository;

    public ProdutoModel cadastrarProduto(ProdutoInput produto) {
        Produto newProduto = produtoAssembler.toEntity(produto);
        produtoRepository.save(newProduto);
        return produtoAssembler.toModel(newProduto);
    }

    public ResponseEntity<Produto> excluirProduto(int produtoCodigo) {
        if (!produtoRepository.findByCodigo(produtoCodigo).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        produtoRepository.deletar(produtoCodigo);
        return ResponseEntity.noContent().build();
    }

    public List<ProdutoModel> listarTodos() {
        return produtoAssembler.toCollectionModel(produtoRepository.findAll());
    }

}
