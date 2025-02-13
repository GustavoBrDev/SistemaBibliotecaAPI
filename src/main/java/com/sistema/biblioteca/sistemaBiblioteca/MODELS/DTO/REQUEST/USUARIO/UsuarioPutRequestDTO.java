package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

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
