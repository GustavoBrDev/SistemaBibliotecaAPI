package com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR.AutorResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO.GeneroResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroAutorResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroGeneroResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um livro
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column ( nullable = false )
    private Integer id;

    @NonNull
    @Column (nullable = false )
    private String nome;

    @NonNull
    @Column ( nullable = false )
    private String dataLancamento;

    private String sinopse;

    @NonNull
    @Column ( nullable = false )
    private Integer quantidadePaginas;

    @NonNull
    @Column (nullable = false, unique = true )
    private Long isbn;

    @NonNull
    @Column ( nullable = false )
    private Boolean emprestado = false;

    @ManyToMany
    private List<Autor> autores;

    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Genero> generos;

    public LivroFullResponseDTO converterTudo ( ){
        return LivroFullResponseDTO.builder().
                id (this.id )
                .nome(this.nome)
                .isbn( this.isbn)
                .dataLancamento( this.dataLancamento )
                .sinopse( this.sinopse )
                .emprestado( this.emprestado )
                .autores( converterAutores() )
                .generos( converterGeneros() )
                .build();
    }

    public LivroAutorResponseDTO converterAutor ( ){

        return LivroAutorResponseDTO.builder().
                id (this.id )
                .nome(this.nome)
                .isbn( this.isbn)
                .dataLancamento( this.dataLancamento )
                .sinopse( this.sinopse )
                .emprestado( this.emprestado )
                .generos( converterGeneros() )
                .build();
    }

    public LivroGeneroResponseDTO converterGenero ( ){

        return LivroGeneroResponseDTO.builder().
                id (this.id )
                .nome(this.nome)
                .isbn( this.isbn)
                .dataLancamento( this.dataLancamento )
                .sinopse( this.sinopse )
                .emprestado( this.emprestado )
                .autores( converterAutores() )
                .build();
    }

    public List<AutorResponseDTO> converterAutores ( ){

        List<AutorResponseDTO> conversao = new ArrayList<>();

        for ( Autor autor : this.autores ){
            conversao.add( autor.converter() );
        }

        return conversao;
    }

    public List<GeneroResponseDTO> converterGeneros ( ){

        List<GeneroResponseDTO> conversao = new ArrayList<>();

        for ( Genero genero : this.generos ){
            conversao.add( genero.converter() );
        }

        return conversao;

    }
}
