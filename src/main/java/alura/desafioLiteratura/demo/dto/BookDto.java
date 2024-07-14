package alura.desafioLiteratura.demo.dto;

import alura.desafioLiteratura.demo.model.author.Author;

public record BookDto(
        String titulo,
        Author authors,
        String idioma,
        int numeroDeDescargas
) {
}
