package com.senai.brasil.domain.service;

import com.senai.brasil.api.assembler.ProdutoAssembler;
import com.senai.brasil.api.model.ProdutoModel;
import com.senai.brasil.api.model.input.ProdutoInput;
import com.senai.brasil.domain.exception.NegocioException;
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
        Produto produto = produtoRepository.findByCodigo2(produtoCodigo);
        if (produto == null) {
            throw new NegocioException("Nao existe um produto com esse codigo para excluir");
        }

        produtoRepository.delete(produto);
        return ResponseEntity.noContent().build();
    }

    public List<ProdutoModel> listarTodos() {
        return produtoAssembler.toCollectionModel(produtoRepository.findAll());
    }

    public ProdutoModel aumentarQuantidade(int produtoCodigo, int quantidade) {
        Produto produto = produtoRepository.findByCodigo2(produtoCodigo);

        if (produto == null) {
            throw new NegocioException("Nao existe um produto com esse codigo para alterar");
        }

        produto.setQuantidade(produto.getQuantidade() + quantidade);
        produtoRepository.save(produto);
        return produtoAssembler.toModel(produto);
    }

    public ProdutoModel diminuirQuantidade(int produtoCodigo, int quantidade) {
        Produto produto = produtoRepository.findByCodigo2(produtoCodigo);

        if (produto == null) {
            throw new NegocioException("Nao existe um produto com esse codigo para excluir");
        }

        if (produto.getQuantidade() < quantidade) {
            throw new NegocioException("Nao tem essa quantidade em estoque para diminuir");
        }

        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtoRepository.save(produto);
        return produtoAssembler.toModel(produto);
    }

    public ProdutoModel alterarPreco(int produtoCodigo, double newValor) {
        Produto produto = produtoRepository.findByCodigo2(produtoCodigo);

        if (produto == null) {
            throw new NegocioException("Nao existe um produto com esse codigo para alterar o preço");
        }

        if (newValor < 1) {
            throw new NegocioException("Insira um valor valido");
        }

        produto.setValorUnitario(newValor);
        produtoRepository.save(produto);
        return produtoAssembler.toModel(produto);
    }
}
