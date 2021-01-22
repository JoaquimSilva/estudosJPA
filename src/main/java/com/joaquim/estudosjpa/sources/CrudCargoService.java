package com.joaquim.estudosjpa.sources;

import com.joaquim.estudosjpa.orm.Cargo;
import com.joaquim.estudosjpa.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private Boolean system = true;
    private final CargoRepository cargorepository;

    public CrudCargoService (CargoRepository cargorepository){
        this.cargorepository = cargorepository;
    }

    public void inicial (Scanner scanner) {
        while (system){
            System.out.println("Qual a ação deseja realizar? ");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");

            int action = scanner.nextInt();
            switch (action){
                case 1: salvar(scanner);
                break;
                case 2: atualizar(scanner);
                break;
                default:
                    break;
            }
        }
    }

    private void salvar (Scanner scanner) {
        System.out.println("Descricao do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargorepository.save(cargo);
        System.out.println("Salvo");
    }

    private void atualizar(Scanner scanner){
        System.out.println("insira o id do cargo");
        int id = scanner.nextInt();
        System.out.println("Digite a nova descrição do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);
    }
}
