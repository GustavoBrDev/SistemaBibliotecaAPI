package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Autor;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
public record AutorRequestDTO( @NotBlank String nome, @NotBlank String dataNascimento, String biografia ) {

    public Autor converter() {
        return Autor.builder().
                nome(this.nome).
                dataNascimento(this.dataNascimento).
                biografia(this.biografia).
                build();
    }
}
