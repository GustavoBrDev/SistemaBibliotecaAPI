package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Usuario;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String senha ) {

    public Usuario converter() {
        return Usuario.builder().
                nome(this.nome).
                email(this.email)
                .senha(this.senha)
                .build();
    }
}
