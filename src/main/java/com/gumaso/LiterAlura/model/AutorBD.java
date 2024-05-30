package com.gumaso.LiterAlura.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "autores")
public class AutorBD {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String nome;
    Integer ano_nascimento;
    Integer ano_falecimento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<LivrosBD> livrosBD;

}
