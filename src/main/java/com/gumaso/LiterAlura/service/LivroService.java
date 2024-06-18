package com.gumaso.LiterAlura.service;

import com.gumaso.LiterAlura.model.*;
import com.gumaso.LiterAlura.repository.AutorRepository;
import com.gumaso.LiterAlura.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final Requisicao requisicao; // Suponho que Requisicao seja a classe que faz a requisição HTTP
    private final ConverteDados converteDados; // Suponho que ConverteDados seja a classe que converte o JSON para objetos
    @Autowired
    private LivrosRepository livroBDRepository;
    @Autowired
    private AutorRepository autorRepository; // Repositório para AutorBD
    @Autowired
    public LivroService(Requisicao requisicao, ConverteDados converteDados, LivrosRepository livroBDRepository) {
        this.requisicao = requisicao;
        this.converteDados = converteDados;
        this.livroBDRepository = livroBDRepository;
    }

    public void salvarLivro(LivroDados livroDados) {
        LivrosBD livroBD = new LivrosBD();
        livroBD.setTitulo(livroDados.titulo());

        AutoresDados autor = livroDados.autores().get(0);
        AutorBD autorBD = autorRepository.findByNome(autor.nome());
        if (autorBD == null) {
            autorBD = new AutorBD(autor.nome());
            autorBD.setAnoNascimento(autor.anoNascimento());
            autorBD.setAnoFalecimento(autor.anoFalecimento());
            autorRepository.save(autorBD);
        }

        livroBD.setAutor(autorBD);
        livroBD.setIdioma(livroDados.idiomas().get(0));
        livroBD.setDownloads(livroDados.downloads());

        try {
            // Verificar se o livro já existe no banco de dados pelo título
            LivrosBD livroExistente = livroBDRepository.findByTitulo(livroBD.getTitulo());
            if (livroExistente != null) {
                System.out.println("Erro ao salvar livro: O livro com título '" + livroBD.getTitulo() + "' já existe.");
                return; // Não tentar salvar novamente
            }

            livroBDRepository.save(livroBD);
            System.out.println("Livro salvo com sucesso no banco de dados!");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Talvez um livro com o mesmo título já exista.");
        }
    }
    public List<LivrosBD> listarLivros() {
        return livroBDRepository.findAll();
    }
    public List<AutorBD> listarAutores(){
        return autorRepository.findAll();
    }
    public List<String> listarAutoresRegistrados() {
        List<AutorBD> autores = autorRepository.findAll();

        return autores.stream().map(autor -> {
            List<String> titulosLivros = autor.getLivrosBD().stream()
                    .map(LivrosBD::getTitulo)
                    .collect(Collectors.toList());

            return String.format("""
                    Autor: %s
                    Ano de nascimento: %d
                    Ano de falecimento: %d
                    Livros: %s
                    """, autor.getNome(), autor.getAnoNascimento(), autor.getAnoFalecimento(), titulosLivros);
        }).collect(Collectors.toList());
    }
    public List<String> listarAutoresVivosEmAno(int ano) {
        List<AutorBD> autores = autorRepository.findAll();

        return autores.stream()
                .filter(autor -> autor.getAnoNascimento() <= ano && (autor.getAnoFalecimento() == null || autor.getAnoFalecimento() > ano))
                .map(autor -> String.format("Autor: %s, Ano de nascimento: %d, Ano de falecimento: %s",
                        autor.getNome(),
                        autor.getAnoNascimento(),
                        autor.getAnoFalecimento() == null ? "Ainda vivo" : autor.getAnoFalecimento().toString()))
                .collect(Collectors.toList());
    }

    public List<String> listarLivrosPorIdioma(String idioma) {
        List<LivrosBD> livros = livroBDRepository.findByIdioma(idioma);

        return livros.stream()
                .map(livro -> String.format("""
                        Título: %s
                        Autor: %s
                        Idioma: %s
                        Número de downloads: %d
                        """, livro.getTitulo(), livro.getAutor().getNome(), livro.getIdioma(), livro.getDownloads()))
                .collect(Collectors.toList());
    }
}