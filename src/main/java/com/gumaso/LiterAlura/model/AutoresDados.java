package com.gumaso.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)

record AutoresDados(
        @JsonAlias("name") String nome,
        @JsonProperty("birth_year") int anoNascimento,
        @JsonProperty("death_year") int anoFalecimento) {
}