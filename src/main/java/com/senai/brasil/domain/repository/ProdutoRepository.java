package com.senai.brasil.domain.repository;

import com.senai.brasil.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p WHERE p.codigo = ?1")
    Produto findByCodigo2(int produtoCodigo);

}
