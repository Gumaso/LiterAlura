package com.gumaso.LiterAlura;

import com.gumaso.LiterAlura.principal.Principal;
import com.gumaso.LiterAlura.repository.LivrosRepository;
import com.gumaso.LiterAlura.service.ConverteDados;
import com.gumaso.LiterAlura.service.LivroService;
import com.gumaso.LiterAlura.service.Requisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	private LivroService livroService;

	@Autowired
	private Requisicao requisicao;

	@Autowired
	private ConverteDados converteDados;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livroService, requisicao, converteDados);
		principal.exibeMenu();
	}
}
