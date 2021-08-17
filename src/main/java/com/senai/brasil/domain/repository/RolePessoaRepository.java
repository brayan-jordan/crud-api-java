package com.senai.brasil.domain.repository;

import com.senai.brasil.domain.model.RolePessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePessoaRepository extends JpaRepository<RolePessoa, Long> {

    @Query("SELECT r FROM RolePessoa r WHERE r.id = ?1")
    RolePessoa findById2(Long codigo);

}
