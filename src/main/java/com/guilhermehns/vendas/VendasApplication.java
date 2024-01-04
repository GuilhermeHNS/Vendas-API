package com.guilhermehns.vendas;

import com.guilhermehns.vendas.domain.entity.Cliente;
import com.guilhermehns.vendas.domain.entity.Pedido;
import com.guilhermehns.vendas.domain.repository.Clientes;
import com.guilhermehns.vendas.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired Clientes clientes,
			@Autowired Pedidos pedidos){
		return args -> {
			System.out.println("Salvando clientes");
			Cliente dougllas = new Cliente("Dougllas");
			clientes.save(dougllas);

			Pedido p = new Pedido();
			p.setCliente(dougllas);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));

			pedidos.save(p);

//			Cliente dougllasPedidos = clientes.findClienteFetchPedidos(dougllas.getId());
//			System.out.println(dougllasPedidos);
//			System.out.println(dougllasPedidos.getPedidos());

			pedidos.findByCliente(dougllas).forEach(System.out::println);


		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
