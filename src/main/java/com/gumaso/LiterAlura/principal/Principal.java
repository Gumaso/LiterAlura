package com.gumaso.LiterAlura.principal;

import com.gumaso.LiterAlura.repository.LivrosRepository;

public class Principal {
    private LivrosRepository repository;
    public Principal(LivrosRepository repository) {
        this.repository = repository;
    }
}
