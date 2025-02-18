package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR.AutorResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO.GeneroResponseDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record LivroFullResponseDTO (
        Integer id,
        String nome,
        String dataLancamento,
        String sinopse,
        Integer quantidadePaginas,
        Long isbn,
        Boolean emprestado,
        List<AutorResponseDTO> autores,
        List<GeneroResponseDTO> generos ) {


}
