package com.guilhermehns.vendas;

import com.guilhermehns.vendas.domain.entity.Cliente;
import com.guilhermehns.vendas.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;
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
			PrintStream var10001 = System.out;
			todosClientes.forEach(var10001::println);
			System.out.println("Atualizando clientes");
			todosClientes.forEach((c) -> {
				c.setNome(c.getNome() + " atualizado.");
				clientes.atualizar(c);
			});
			todosClientes = clientes.obterTodos();
			var10001 = System.out;
			todosClientes.forEach(var10001::println);
			System.out.println("Buscando clientes");
			List var10000 = clientes.buscarPorNome("Cli");
			var10001 = System.out;
			var10000.forEach(var10001::println);
			System.out.println("deletando clientes");
			clientes.obterTodos().forEach((c) -> {
				clientes.deletar(c);
			});
			todosClientes = clientes.obterTodos();
			if (todosClientes.isEmpty()) {
				System.out.println("Nenhum cliente encontrado.");
			} else {
				var10001 = System.out;
				todosClientes.forEach(var10001::println);
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
