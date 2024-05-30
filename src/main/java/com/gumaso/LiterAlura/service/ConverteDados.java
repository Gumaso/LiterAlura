package com.gumaso.LiterAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverteDados implements IConverteDados{
    @Override
    public <T> T obterDados(String json, Class<T> aClass) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var objetoResultado = mapper.readValue(json, aClass);
        return objetoResultado;
    }

    @Override
    public <T> List<T> obterDadosLista(String json, Class<T> tList) {
        ObjectMapper mapper = new ObjectMapper();
        CollectionType lista = mapper.getTypeFactory().constructCollectionType(List.class, tList);
        try {
            return mapper.readValue(json, lista);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
