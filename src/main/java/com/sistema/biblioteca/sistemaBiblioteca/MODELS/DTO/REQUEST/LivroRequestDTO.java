package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.NonNull;

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
