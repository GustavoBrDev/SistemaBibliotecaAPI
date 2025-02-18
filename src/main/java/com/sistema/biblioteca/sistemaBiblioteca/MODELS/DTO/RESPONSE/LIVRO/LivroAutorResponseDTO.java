package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO.GeneroResponseDTO;
import lombok.Builder;

import java.util.List;

/**
 * Record de DTO para o recurso de livros.
 * Utilizado para retornar as informações do livro sem os autores.
 * @param id id do livro
 * @param nome nome do livro
 * @param dataLancamento data de lançamento do livro
 * @param sinopse sinopse do livro
 * @param quantidadePaginas quantidade de paginas do livro
 * @param isbn isbn do livro
 * @param emprestado booleano indicando se o livro foi emprestado
 * @param generos generos do livro em forma de {@link GeneroResponseDTO}
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @see GeneroResponseDTO
 */
@Builder
public record LivroAutorResponseDTO(Integer id, String nome, String dataLancamento, String sinopse, Integer quantidadePaginas, Long isbn, Boolean emprestado, List<GeneroResponseDTO> generos ) {
}
