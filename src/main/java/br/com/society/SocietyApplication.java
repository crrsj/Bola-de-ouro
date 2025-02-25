package br.com.society;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Bola De Ouro.",
				version = "1.0",
				description = "API ALUGUEL DE CAMPO SOCIETY .",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class SocietyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocietyApplication.class, args);
	}

}
