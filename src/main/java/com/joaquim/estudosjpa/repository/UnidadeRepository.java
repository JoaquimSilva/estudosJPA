package com.joaquim.estudosjpa.repository;

import com.joaquim.estudosjpa.orm.Funcionario;
import com.joaquim.estudosjpa.orm.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends CrudRepository<UnidadeTrabalho, Integer> {
}
