package com.gumaso.LiterAlura.repository;

import com.gumaso.LiterAlura.model.AutorBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorBD, Long> {
    AutorBD findByNome(String nome);
}
