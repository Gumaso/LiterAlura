package com.gumaso.LiterAlura.service;

import com.gumaso.LiterAlura.model.AutorBD;
import com.gumaso.LiterAlura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void salvarAutor(AutorBD autor) {
        autorRepository.save(autor);
    }

    public Optional<AutorBD> buscarAutorPorId(Long id) {
        return autorRepository.findById(id);
    }

    public List<AutorBD> listarAutores() {
        return autorRepository.findAll();
    }

    public void deletarAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
