package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Record de DTO para o recurso de gênero.
 * Utilizado para atualização de gênero.
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @param id id do gênero a ser atualizado
 * @param nome nome do gênero a ser atualizado
 * @param descricao descrição do gênero a ser atualizado (opcional)
 */
public record GeneroPutRequestDTO(@NotNull @Positive Integer id, @NotBlank String nome, String descricao ) {

    public Genero converter() {
        return Genero.builder()
                .id(this.id)
                .nome(this.nome)
                .descricao(this.descricao)
                .build();
    }
}
