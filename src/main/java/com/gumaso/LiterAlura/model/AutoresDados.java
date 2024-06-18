package com.gumaso.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)

public record AutoresDados(
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year") int anoNascimento,
        @JsonAlias("death_year") int anoFalecimento) {
}