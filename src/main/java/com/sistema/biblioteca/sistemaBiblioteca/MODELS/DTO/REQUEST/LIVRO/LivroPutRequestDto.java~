package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LivroPutRequestDto {

    @NotNull
    @Positive
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String dataLancamento;

    private String sinopse;

    @NotNull
    @Positive
    private Integer quantidadePaginas;

    @NotNull
    private Long isbn;

    @NotNull
    private Boolean emprestado;


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
