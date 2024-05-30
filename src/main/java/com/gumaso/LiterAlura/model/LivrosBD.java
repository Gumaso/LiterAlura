package com.gumaso.LiterAlura.model;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "livros")
public class LivrosBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String titulo;
    @ManyToOne()
    @JoinColumn(name = "autor_id")
    AutorBD autor;
    String idioma;
    Integer downloads;

}
