package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LivroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LivroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.LivroRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LivroService {

    private LivroRepository livroRepository;

    public LivroFullResponseDTO criarLivro (LivroRequestDTO livroRequestDTO ){

        Livro livro = livroRequestDTO.converter();

        return livroRepository.save( livro ).converterTudo();

    }

    public LivroFullResponseDTO buscarLivro ( Integer id ){

        return livroRepository.findById( id ).get().converterTudo();
    }

    public LivroFullResponseDTO atualizarLivro ( LivroRequestDTO livroRequestDTO, Integer id ){

        Livro livro = livroRequestDTO.converter();
        livro.setId( id );

        if ( livroRepository.existsById(id) ){
            return livroRepository.save( livro ).converterTudo();
        }

        throw
    }
}
