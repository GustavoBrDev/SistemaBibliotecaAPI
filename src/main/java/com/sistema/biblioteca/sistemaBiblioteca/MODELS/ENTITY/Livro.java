package com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AutorResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GeneroResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LivroFullResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn ( nullable = false )
    private List<Autor> autores;

    @ManyToMany
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

    public List<AutorResponseDTO> converterAutores ( ){

        List<AutorResponseDTO> conversao = new ArrayList<>();

        for ( Autor autor : this.autores ){
            conversao.add( autor.conveter() );
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
