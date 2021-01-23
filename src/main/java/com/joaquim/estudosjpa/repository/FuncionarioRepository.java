package com.joaquim.estudosjpa.repository;

import com.joaquim.estudosjpa.orm.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
}
