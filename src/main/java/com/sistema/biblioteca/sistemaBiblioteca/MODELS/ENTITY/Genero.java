package com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GeneroResponseDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genero {

    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY )
    private Integer id;

    @NonNull
    @Column ( nullable = false )
    private String nome;

    private String descricao;

    @ManyToMany (mappedBy = "categorias")
    @JsonIgnore
    @ToString.Exclude
    private List<Livro> livros;

    public GeneroResponseDTO converter ( ){
        return GeneroResponseDTO.builder()
                .id ( this.id )
                .descricao( this.descricao )
                .nome ( this.nome )
                .build();
    }

}
