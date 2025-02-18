package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Usuario;
import jakarta.validation.constraints.NotBlank;

/**
 * Record de DTO para o recurso de usuarios.
 * Utilizado para criação de usuarios.
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @param nome nome do usuario a ser criado
 * @param email email do usuario a ser criado
 * @param senha senha do usuario a ser criado
 */
public record UsuarioRequestDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String senha ) {

    public Usuario converter() {
        return Usuario.builder().
                nome(this.nome).
                email(this.email)
                .senha(this.senha)
                .build();
    }
}
