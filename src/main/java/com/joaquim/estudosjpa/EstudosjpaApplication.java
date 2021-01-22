package com.joaquim.estudosjpa;

import com.joaquim.estudosjpa.orm.Cargo;
import com.joaquim.estudosjpa.repository.CargoRepository;
import com.joaquim.estudosjpa.sources.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class EstudosjpaApplication implements CommandLineRunner {

	private boolean sistem = true;

	private final CrudCargoService cargoService;

	public EstudosjpaApplication (CrudCargoService cargoService){
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(EstudosjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cargo cargo = new Cargo();
		Scanner scanner = new Scanner(System.in);
		while (sistem){
			System.out.println("qual ação você quer executar");
			System.out.println("0 - sair");
			System.out.println("1 - cargo");

			int action = scanner.nextInt();
			if (action == 1 ){
				cargoService.inicial(scanner);
			}else {
				sistem = false;
			}
		}
	}
}
