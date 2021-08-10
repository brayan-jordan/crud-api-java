package com.senai.brasil.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoModel {

    int codigo;
    String nome;
    int quantidade;
    double valorUnitario;
    double valorTotalEmEstoque;

}
