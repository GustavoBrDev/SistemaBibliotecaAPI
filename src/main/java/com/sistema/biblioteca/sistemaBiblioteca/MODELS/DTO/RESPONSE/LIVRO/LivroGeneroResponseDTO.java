package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR.AutorResponseDTO;
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
 * @param autores autores do livro em forma de {@link AutorResponseDTO}
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @see AutorResponseDTO
 */
@Builder
public record LivroGeneroResponseDTO(Integer id, String nome, String dataLancamento, String sinopse, Integer quantidadePaginas, Long isbn, Boolean emprestado, List<AutorResponseDTO> autores ) {
}