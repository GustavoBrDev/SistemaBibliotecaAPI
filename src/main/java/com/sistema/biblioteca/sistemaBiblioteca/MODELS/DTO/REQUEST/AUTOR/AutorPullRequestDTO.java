package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AutorPullRequestDTO {

    @NotNull 
    @Positive
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String dataNascimento;

    private String biografia;

    public Autor converter() {
        return Autor.builder().
                id(this.id).
                nome(this.nome).
                dataNascimento(this.dataNascimento).
                biografia(this.biografia).
                build();
    }
}
