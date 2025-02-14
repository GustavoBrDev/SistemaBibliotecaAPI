package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO.EmprestimoResponseDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record UsuarioFullResponseDTO(Integer id, String nome, String email, String senha, List<EmprestimoResponseDTO> emprestimos ) {
}
