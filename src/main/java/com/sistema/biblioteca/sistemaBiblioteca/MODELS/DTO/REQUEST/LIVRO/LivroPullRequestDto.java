package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public class LivroPullRequestDto {

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


}
