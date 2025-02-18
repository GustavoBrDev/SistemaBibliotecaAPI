package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.NonNull;

/**
 * Record de DTO para o recurso de livros.
 * Utilizado para criação de livros.
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @param nome nome do livro a ser criado
 * @param dataLancamento data de lancamento do livro a ser criado
 * @param sinopse sinopse do livro a ser criado (opcional)
 * @param quantidadePaginas quantidade de paginas do livro a ser criado
 * @param isbn isbn do livro a ser criado
 * @param emprestado booleano indicando se o livro foi emprestado
 */
public record LivroRequestDTO(
        @NotBlank String nome,
        @NotBlank String dataLancamento,
        String sinopse,
        @NonNull @Positive Integer quantidadePaginas,
        @NonNull @Positive Long isbn,
        Boolean emprestado ) {

    public Livro converter (){
        return Livro.builder().
                quantidadePaginas( this.quantidadePaginas)
                .nome(this.nome)
                .dataLancamento( this.dataLancamento )
                .sinopse( this.sinopse )
                .quantidadePaginas(this.quantidadePaginas)
                .isbn(this.isbn)
                .emprestado(this.emprestado)
                .build();
    }
}
