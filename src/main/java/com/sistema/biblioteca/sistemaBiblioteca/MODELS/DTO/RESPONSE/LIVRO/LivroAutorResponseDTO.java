package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GeneroResponseDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record LivroAutorResponseDTO(Integer id, String nome, String dataLancamento, String sinopse, Integer quantidadePaginas, Long isbn, Boolean emprestado, List<GeneroResponseDTO> generos ) {
}
