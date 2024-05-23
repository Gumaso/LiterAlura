package com.gumaso.LiterAlura.repository;

import com.gumaso.LiterAlura.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
}
