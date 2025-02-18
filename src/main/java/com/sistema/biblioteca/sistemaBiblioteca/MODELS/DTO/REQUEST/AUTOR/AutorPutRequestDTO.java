package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

/**
 * Record de DTO para o recurso de autores.
 * Utilizado para atualização de autores.
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
public record AutorPutRequestDTO(

    @NotNull
    @Positive
    Integer id,

    @NotBlank String nome,

    @NotBlank
    String dataNascimento,

    String biografia ){

    public Autor converter() {
        return Autor.builder().
                id(this.id).
                nome(this.nome).
                dataNascimento(this.dataNascimento).
                biografia(this.biografia).
                build();
    }
}
