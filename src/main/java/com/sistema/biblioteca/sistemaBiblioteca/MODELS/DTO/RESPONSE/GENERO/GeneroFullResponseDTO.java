package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroGeneroResponseDTO;
import lombok.Builder;

import java.util.List;

/**
 * Record de DTO para o recurso de genero.
 * Utilizado para retornar TODAS as informações de um genero.
 * @param id id do genero
 * @param nome nome do genero
 * @param descricao descricao do genero
 * @param livros livros do genero em forma de {@link LivroGeneroResponseDTO}
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @see LivroGeneroResponseDTO
 */
@Builder
public record GeneroFullResponseDTO(
        Integer id,
        String nome,
        String descricao,
        List<LivroGeneroResponseDTO> livros) {
}
