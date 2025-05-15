package com.sistema_gerenciamento.api_cadastro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ApiCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCadastroApplication.class, args);
	}

	@Bean
	public CommandLineRunner listarBeans(ApplicationContext ctx) {
		return args -> {
			System.out.println("\n--- BEANS REGISTRADOS ---\n");
			String[] nomes = ctx.getBeanDefinitionNames();
			Arrays.sort(nomes);
			for (String nome : nomes) {
				if (nome.toLowerCase().contains("usuario")) {
					System.out.println(nome);
				}
			}
			System.out.println("\n--------------------------\n");
		};
	}
}
