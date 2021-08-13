package com.senai.brasil.domain.repository;

import com.senai.brasil.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p WHERE p.codigo = ?1")
    Optional<Produto> findByCodigo(int produtoCodigo);

    @Transactional
    @Modifying
    @Query("DELETE FROM Produto p WHERE p.codigo = ?1")
    Optional<Produto> deletar(int produtoCodigo);

}
