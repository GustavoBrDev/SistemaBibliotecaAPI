package com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AutorResponseDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Integer id;

    @NonNull
    @Column ( nullable = false )
    private String nome;

    @NonNull
    @Column ( nullable = false )
    private String dataNascimento;

    private String biografia;

    @ManyToMany ( mappedBy = "autores")
    @JsonIgnore
    @ToString.Exclude
    private List<Livro> livros;

    public AutorResponseDTO conveter ( ){
        return AutorResponseDTO.builder().
                id(this.id).
                nome(this.nome)
                .dataNascimento( this.dataNascimento )
                .biografia( this.biografia).build();
    }
}
