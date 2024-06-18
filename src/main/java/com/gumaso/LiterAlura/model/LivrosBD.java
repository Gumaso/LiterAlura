package com.gumaso.LiterAlura.model;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "livros")
public class LivrosBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne()
    @JoinColumn(name = "autor_id")
    AutorBD autor;
    String idioma;
    Integer downloads;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public AutorBD getAutor() {
        return autor;
    }

    public void setAutor(AutorBD autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

}
