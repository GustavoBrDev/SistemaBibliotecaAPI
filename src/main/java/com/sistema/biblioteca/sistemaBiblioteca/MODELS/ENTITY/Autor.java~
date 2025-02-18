package com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR.AutorFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR.AutorResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroAutorResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
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

    public AutorResponseDTO converter( ){
        return AutorResponseDTO.builder().
                id(this.id).
                nome(this.nome)
                .dataNascimento( this.dataNascimento )
                .biografia( this.biografia).build();
    }

    public AutorFullResponseDTO converterTudo ( ){
        return AutorFullResponseDTO.builder().
                id(this.id).
                nome(this.nome)
                .dataNascimento( this.dataNascimento )
                .biografia( this.biografia)
                .livros( converterLivros() ).build();
    }

    public List<LivroAutorResponseDTO> converterLivros ( ){

        List<LivroAutorResponseDTO> conversao = new ArrayList<>();

        for ( Livro livro : this.livros ){
            conversao.add( livro.converterAutor() );
        }

        return conversao;
    }
}
