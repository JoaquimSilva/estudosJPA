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
            System.out.println("3 - Visualizar Cargo");
            System.out.println("4 - Delete");

            int action = scanner.nextInt();
            switch (action){
                case 1: salvar(scanner);
                break;
                case 2: atualizar(scanner);
                break;
                case 3: visualizar();
                break;
                case 4: delete(scanner);
                    break;
                default:
                    system = false;
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
        cargorepository.save(cargo);
        System.out.println("Atualizado");
    }

    private void visualizar() {
        Iterable<Cargo> cargos = cargorepository.findAll();
        cargos.forEach(cargos1 -> System.out.println(cargos1));
    }

    private void delete(Scanner scanner) {
        System.out.println("Digite o ID para ser deletado");
        int id = scanner.nextInt();
        cargorepository.deleteById(id);
        System.out.println("Id deletado com sucesso");
    }
}
