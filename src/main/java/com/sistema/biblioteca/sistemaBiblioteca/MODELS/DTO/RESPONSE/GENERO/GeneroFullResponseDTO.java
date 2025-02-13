package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroGeneroResponseDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record GeneroFullResponseDTO(
        Integer id,
        String nome,
        String descricao,
        List<LivroGeneroResponseDTO> livros) {
}
