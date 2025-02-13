package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record GeneroPullRequestDTO(@NotNull @Positive Integer id, @NotBlank String nome, String descricao ) {

    public Genero converter() {
        return Genero.builder()
                .id(this.id)
                .nome(this.nome)
                .descricao(this.descricao)
                .build();
    }
}
