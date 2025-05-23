package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Autor;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
/**
 * Record de DTO para o recurso de autores.
 * Utilizado para criação de autores.
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @param nome nome do autor a ser criado
 * @param dataNascimento data de nascimento do autor a ser criado
 * @param biografia biografia do autor a ser criado (opcional)
 */
public record AutorRequestDTO( @NotBlank String nome, @NotBlank String dataNascimento, String biografia ) {

    public Autor converter() {
        return Autor.builder().
                nome(this.nome).
                dataNascimento(this.dataNascimento).
                biografia(this.biografia).
                build();
    }
}
