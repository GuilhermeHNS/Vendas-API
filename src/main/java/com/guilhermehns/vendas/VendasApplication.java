package com.guilhermehns.vendas;

import com.guilhermehns.vendas.domain.entity.Cliente;
import com.guilhermehns.vendas.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

	@Bean
	public CommandLineRunner init( @Autowired Clientes clientes){
		return args -> {
			clientes.salvar(new Cliente("Guilherme"));
			clientes.salvar(new Cliente("Raphael"));

			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			clientes.atualizar(new Cliente(1, "Gabriel"));
			clientes.atualizar(new Cliente(2, "Maria Gabriele"));

			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			List<Cliente> clientesPorNome = clientes.buscarPorNome("gabri");
			clientesPorNome.forEach(System.out::println);

			clientes.obterTodos().forEach(c -> {
				clientes.deletar(c);
			});

			todosClientes = clientes.obterTodos();
			if(todosClientes.isEmpty()){
				System.out.println("NENHUM CLIENTE ENCONTRADO");
			}else{
				todosClientes.forEach(System.out::println);
			}


		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
