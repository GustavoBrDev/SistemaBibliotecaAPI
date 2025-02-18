package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

/**
 * Record de DTO para o recurso de livros.
 * Utilizado para atualização de livros.
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @param id id do livro a ser atualizado
 * @param nome nome do livro a ser atualizado
 * @param dataLancamento data de lancamento do livro a ser atualizado
 * @param sinopse sinopse do livro a ser atualizado
 * @param quantidadePaginas quantidade de paginas do livro a ser atualizado
 * @param isbn isbn do livro a ser atualizado
 * @param emprestado status de emprestimo do livro a ser atualizado
 */
public record LivroPutRequestDto (

    @NotNull
    @Positive
    Integer id,

    @NotBlank
    String nome,

    @NotBlank
    String dataLancamento,

    String sinopse,

    @NotNull
    @Positive
    Integer quantidadePaginas,

    @NotNull
    Long isbn,

    @NotNull
    Boolean emprestado

){

    public Livro converter() {
        return Livro.builder()
                .id(this.id)
                .nome(this.nome)
                .dataLancamento(this.dataLancamento)
                .sinopse(this.sinopse)
                .quantidadePaginas(this.quantidadePaginas)
                .isbn(this.isbn)
                .emprestado(this.emprestado)
                .build();
    }
}
