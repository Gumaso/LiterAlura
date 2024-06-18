package com.gumaso.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroRequisicao {
    private List<LivroDados> results;

    // Getters and setters
    public List<LivroDados> getResults() {
        return results;
    }

    public void setResults(List<LivroDados> results) {
        this.results = results;
    }
}
