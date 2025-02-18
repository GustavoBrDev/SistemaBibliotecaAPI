package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Record de DTO para o recurso de usuarios.
 * Utilizado para atualização de usuarios.
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @param id id do usuario a ser atualizado
 * @param nome nome do usuario a ser atualizado
 * @param email email do usuario a ser atualizado
 * @param senha senha do usuario a ser atualizado
 */
public record UsuarioPutRequestDTO(@NotNull @Positive Integer id, @NotBlank String nome, @NotBlank String email, @NotBlank String senha ) {

    public Usuario converter() {
        return Usuario.builder().
                id(this.id).
                nome(this.nome).
                email(this.email).
                senha(this.senha).
                build();
    }
}
