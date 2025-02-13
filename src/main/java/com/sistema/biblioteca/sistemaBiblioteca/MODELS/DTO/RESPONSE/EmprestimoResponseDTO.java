package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import lombok.Builder;

@Builder
public record EmprestimoResponseDTO( Integer id, String dataInicio, String dataDevolucao, Float valorMulta, Boolean devolvido, LivroFullResponseDTO livro ) {
}
