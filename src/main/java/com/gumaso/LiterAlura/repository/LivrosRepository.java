package com.gumaso.LiterAlura.repository;

import com.gumaso.LiterAlura.model.LivrosBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivrosRepository extends JpaRepository<LivrosBD, Long> {
    List<LivrosBD> findByIdioma(String idioma);

    LivrosBD findByTitulo(String titulo);
}
