# LiterAlura

## Descrição
LiterAlura é uma aplicação Java para gerenciar informações sobre livros. Ela permite buscar livros por título, listar livros registrados, autores, autores vivos em um determinado ano e livros em um determinado idioma. A aplicação utiliza JSON para comunicar-se com um serviço externo e usa o Jackson para mapear os dados recebidos em objetos Java.

## Estrutura do Projeto
- **Pacote Principal**: 
    - `com.gumaso.LiterAlura.principal`
    - **Classe Principal**: 
      - `Principal`
- **Modelos**: 
  - `com.gumaso.LiterAlura.model`
      - `AutorBD`
      - `AutoresDados`
      - `IdiomasDados`
      - `LivroDados`
      - `LivroRequisicao`
      - `LivrosBD`
- **Repositório**: 
  - `com.gumaso.LiterAlura.repository`
     - `AutorRepository`
     - `LivrosRepository`
- **Serviços**: 
  - `com.gumaso.LiterAlura.service`
    - `AutorService`
    - `ConverteDados`
    - `IConverteDados`
    - `LivroService`
    - `Requisicao_`

## Funcionalidades
### 1. Buscar Livro pelo Título
Permite buscar um livro pelo título digitado. Exibe as informações do livro e salva os dados no repositório.
### 2. Listar Livros Registrados
Lista todos os livros registrados no repositório.
### 3. Listar Autores Registrados
Lista todos os autores registrados no repositório.
### 4. Listar Autores Vivos em um Determinado Ano
Lista todos os autores que estavam vivos em um determinado ano informado pelo usuário.
### 5. Listar Livros em um Determinado Idioma
Lista todos os livros disponíveis em um idioma específico.

## Tags
- Java
- Livros
- Gerenciamento
- JSON
- Jackson
- Repositório
- Autores
- Idiomas




