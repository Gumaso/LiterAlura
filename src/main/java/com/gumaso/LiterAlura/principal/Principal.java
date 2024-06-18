package com.gumaso.LiterAlura.principal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gumaso.LiterAlura.model.LivroDados;
import com.gumaso.LiterAlura.model.LivroRequisicao;
import com.gumaso.LiterAlura.model.LivrosBD;
import com.gumaso.LiterAlura.repository.LivrosRepository;
import com.gumaso.LiterAlura.service.ConverteDados;
import com.gumaso.LiterAlura.service.LivroService;
import com.gumaso.LiterAlura.service.Requisicao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private LivrosRepository repository;
    private final LivroService livroService;
    private final Scanner sc = new Scanner(System.in);
    private final Requisicao requisicao;
    public Principal(LivroService livroService, Requisicao requisicao, ConverteDados converteDados) {
        this.livroService = livroService;
        this.requisicao = requisicao;
    }

    public void exibeMenu() throws IOException, InterruptedException {
        while (true){
            System.out.println("""
                *******LiterAlura*************
                1 - buscar livro pelo titulo
                2 - listar livros registrados
                3 - listar autores registrados
                4 - listar autores vivos em um determinado ano
                5 - listar livros em um determinado idioma
                0 - sair
                *****************************************
                """);
            int opcaoEscolha = sc.nextInt();
            sc.nextLine();
            if (opcaoEscolha == 0){
                System.out.println("Porgrama encerrado!");
                break;
            }
            switch ( opcaoEscolha){
                case 1:
                    buscarRegistrarLivro();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    verificarAutorVivo();
                    break;
                case 5:
                    buscandoPorIdioma();
                    break;

            }

        }
    }

    private void buscarRegistrarLivro() throws IOException, InterruptedException {
        System.out.println("Digite o nome do livro: ");
        String nomeLivro = sc.nextLine();
        String json = requisicao.recebendoJson(nomeLivro);
        ObjectMapper mapper = new ObjectMapper();
        try {
            LivroRequisicao bookResponse = mapper.readValue(json, LivroRequisicao.class);
            LivroDados book = bookResponse.getResults().getFirst();
            String titulo = book.titulo();
            String nomeAutor = String.valueOf(book.autores().getFirst().nome());
            String idiomas = book.idiomas().getFirst();
            int downloads = book.downloads();
            System.out.printf("""
                    Título: %s
                    Autor: %s
                    Idioma: %s
                    Número de downloads: %s
                    %n""", titulo, nomeAutor, idiomas, downloads);
            livroService.salvarLivro(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listarLivrosRegistrados() {
        List<LivrosBD> livrosRegistrados = livroService.listarLivros();
        livrosRegistrados.forEach(obj -> System.out.println(obj.getAutor()));
        List<LivrosBD> livros = livroService.listarLivros();
        for (LivrosBD livro : livros) {
            System.out.printf("""
                    Título: %s
                    Autor: %s
                    Idioma: %s
                    Número de downloads: %d
                    %n""", livro.getTitulo(), livro.getAutor().getNome(), livro.getIdioma(), livro.getDownloads());
        }
    }

    private void listarAutores() {
        livroService.listarAutoresRegistrados().forEach(System.out::println);
    }

    public void verificarAutorVivo(){
        System.out.println("Insira o ano a ser verificado: ");
        int ano = sc.nextInt();
        sc.nextLine();
        livroService.listarAutoresVivosEmAno(ano).forEach(System.out::println);
    }
    public void buscandoPorIdioma(){
        System.out.println("Insira o idioma para realizar a busca:");
        System.out.println("es- espanhol");
        System.out.println("en- inglês");
        System.out.println("fr- francês");
        System.out.println("pt- português");
        String idioma = sc.nextLine();
        List<String> livrosPorIdioma = livroService.listarLivrosPorIdioma(idioma);
        for (String livro : livrosPorIdioma) {
            System.out.println(livro);
        }
    }
}

