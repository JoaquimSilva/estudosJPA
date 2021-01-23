package com.joaquim.estudosjpa.repository;

import com.joaquim.estudosjpa.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository <Cargo,Integer> {

}
