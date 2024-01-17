package com.guilhermehns.vendas;

import com.guilhermehns.vendas.domain.entity.Cliente;
import com.guilhermehns.vendas.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
@RestController
public class VendasApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
