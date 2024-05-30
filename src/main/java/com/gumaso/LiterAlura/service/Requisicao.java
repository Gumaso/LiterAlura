package com.gumaso.LiterAlura.service;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Requisicao {


    public String recebendoJson(String endereco) throws IOException, InterruptedException {
        String nomeFormatado = URLEncoder.encode(endereco, StandardCharsets.UTF_8);
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL) // Permite seguir redirecionamentos
                .build();
        String enderecoFormatado = "https://gutendex.com/books?search="+nomeFormatado;

        HttpRequest request = HttpRequest.newBuilder(URI.create(enderecoFormatado))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 301) {
            // Se houver um redirecionamento, obtenha a nova URL do cabeçalho 'Location'
            HttpHeaders headers = response.headers();
            String newLocation = headers.firstValue("Location").orElse("");
            if (!newLocation.isEmpty()) {
                System.out.println("Redirecionando para: " + newLocation);
                // Faça uma nova solicitação para a URL redirecionada
                return recebendoJson(newLocation);
            }
        }
        System.out.println(response.body());
        return response.body();
    }
}
