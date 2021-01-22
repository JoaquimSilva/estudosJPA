package com.joaquim.estudosjpa.sources;

import com.joaquim.estudosjpa.orm.Cargo;
import com.joaquim.estudosjpa.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository cargorepository;

    public CrudCargoService (CargoRepository cargorepository){
        this.cargorepository = cargorepository;
    }

    public void inicial (Scanner scanner) {
        salvar(scanner);
    }

    private void salvar (Scanner scanner) {
        System.out.println("Descricao do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargorepository.save(cargo);
        System.out.println("Salvo");
    }
}
