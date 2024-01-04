package com.guilhermehns.vendas;

import com.guilhermehns.vendas.domain.entity.Cliente;
import com.guilhermehns.vendas.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

	@Bean
	public CommandLineRunner init( @Autowired Clientes clientes){
		return args -> {
			System.out.println("Salvando clientes");
			clientes.salvar(new Cliente("Dougllas"));
			clientes.salvar(new Cliente("Outro Cliente"));

			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
