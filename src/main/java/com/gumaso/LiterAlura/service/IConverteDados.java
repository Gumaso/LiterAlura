package com.gumaso.LiterAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> aClass) throws JsonProcessingException;
    <T> List<T> obterDadosLista(String json, Class<T> tList);
}
