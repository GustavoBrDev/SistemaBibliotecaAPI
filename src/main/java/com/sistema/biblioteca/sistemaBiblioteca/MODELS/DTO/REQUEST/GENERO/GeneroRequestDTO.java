package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Genero;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public record GeneroRequestDTO( @NotBlank String nome, String descricao) {

    public Genero converter() {
        return Genero.builder().nome(this.nome).descricao(this.descricao).build();
    }
}
