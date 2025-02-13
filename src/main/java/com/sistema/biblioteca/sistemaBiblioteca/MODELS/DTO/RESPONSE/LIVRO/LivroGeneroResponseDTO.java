package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR.AutorResponseDTO;
import lombok.Builder;

import java.util.List;
@Builder
public record LivroGeneroResponseDTO(Integer id, String nome, String dataLancamento, String sinopse, Integer quantidadePaginas, Long isbn, Boolean emprestado, List<AutorResponseDTO> autores ) {
}