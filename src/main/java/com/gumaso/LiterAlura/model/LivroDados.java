package com.gumaso.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDados(
        int id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutoresDados> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") int downloads) {
}