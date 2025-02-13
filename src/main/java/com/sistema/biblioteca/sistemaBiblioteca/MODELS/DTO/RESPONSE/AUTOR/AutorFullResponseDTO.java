package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroAutorResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record AutorFullResponseDTO (
        Integer id,
        String nome,
        String dataNascimento,
        String biografia,
        List<LivroAutorResponseDTO> livros ) {
}
