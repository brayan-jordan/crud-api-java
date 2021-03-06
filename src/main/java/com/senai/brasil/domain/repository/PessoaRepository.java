package com.senai.brasil.domain.repository;

import com.senai.brasil.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p FROM Pessoa p WHERE p.email = ?1")
    Pessoa findByEmail(String email);

    @Query("SELECT p FROM Pessoa p WHERE p.codigo = ?1")
    Pessoa findByCodigo(int pessoaCodigo);

}
