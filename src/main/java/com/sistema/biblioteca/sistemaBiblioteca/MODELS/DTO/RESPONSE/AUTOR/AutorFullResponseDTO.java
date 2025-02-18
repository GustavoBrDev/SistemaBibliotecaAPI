package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroAutorResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import lombok.Builder;

import java.util.List;

/**
 * Record de DTO para o recurso de autores.
 * Utilizado para retornar TODAS as informações de um autor.
 * @param id id do autor
 * @param nome nome do autor
 * @param dataNascimento data de nascimento do autor
 * @param biografia biografia do autor
 * @param livros livros do autor em forma de {@link LivroAutorResponseDTO}
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @see LivroAutorResponseDTO
 */
@Builder
public record AutorFullResponseDTO (
        Integer id,
        String nome,
        String dataNascimento,
        String biografia,
        List<LivroAutorResponseDTO> livros ) {
}
