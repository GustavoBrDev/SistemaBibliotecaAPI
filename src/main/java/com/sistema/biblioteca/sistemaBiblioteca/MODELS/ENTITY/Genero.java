package com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO.GeneroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO.GeneroResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroGeneroResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
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

    public GeneroFullResponseDTO converterTudo ( ){
        return GeneroFullResponseDTO.builder()
                .id ( this.id )
                .descricao( this.descricao )
                .nome ( this.nome )

                .build();
    }

    public List<LivroGeneroResponseDTO> converterLivros ( ){

        List<LivroGeneroResponseDTO> conversao = new ArrayList<>();

        for ( Livro livro : this.livros ){
            conversao.add( livro.converterGenero() );
        }

        return conversao;

    }

}
