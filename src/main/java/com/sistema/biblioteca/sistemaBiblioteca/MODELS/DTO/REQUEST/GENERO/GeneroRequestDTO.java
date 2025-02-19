package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Genero;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Record de DTO para o recurso de genero.
 * Utilizado para criação de genero.
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @param nome nome do genero a ser criado
 * @param descricao descricao do genero a ser criado (opcional)
 */
public record GeneroRequestDTO( @NotBlank String nome, String descricao) {

    public Genero converter() {
        return Genero.builder().nome(this.nome).descricao(this.descricao).build();
    }
}
