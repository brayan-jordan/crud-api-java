package com.senai.brasil.api.assembler;

import com.senai.brasil.api.model.ProdutoModel;
import com.senai.brasil.api.model.input.ProdutoInput;
import com.senai.brasil.domain.model.Produto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProdutoAssembler {

    private ModelMapper modelMapper;

    public Produto toEntity(ProdutoInput produtoInput) {
        return modelMapper.map(produtoInput, Produto.class);
    }

    public ProdutoModel toModel(Produto produto) {
        ProdutoModel returnModel = modelMapper.map(produto, ProdutoModel.class);
        returnModel.setValorTotalEmEstoque(returnModel.getValorUnitario() * returnModel.getQuantidade());
        return returnModel;
    }

    public List<ProdutoModel> toCollectionModel(List<Produto> produtos) {
        return produtos.stream().map(this::toModel).collect(Collectors.toList());
    }

}
