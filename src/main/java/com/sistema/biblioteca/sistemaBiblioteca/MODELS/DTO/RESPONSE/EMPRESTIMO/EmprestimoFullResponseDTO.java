package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO.UsuarioResponseDTO;
import lombok.Builder;

@Builder
public record EmprestimoFullResponseDTO(Integer id, String dataInicio, String dataDevolucao, Float valorMulta, Boolean devolvido, LivroFullResponseDTO livro, UsuarioResponseDTO usuario) {
}
