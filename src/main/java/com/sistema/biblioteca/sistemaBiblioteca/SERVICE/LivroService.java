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
}
