package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO.EmprestimoResponseDTO;
import lombok.Builder;

import java.util.List;

/**
 * Record de DTO para o recurso de usuarios.
 * Utilizado para retornar TODAS as informacoes de um usuario.
 * @param id id do usuario
 * @param nome nome do usuario
 * @param email email do usuario
 * @param senha senha do usuario
 * @param emprestimos emprestimos do usuario em forma de {@link EmprestimoResponseDTO}
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @see EmprestimoResponseDTO
 */
@Builder
public record UsuarioFullResponseDTO(Integer id, String nome, String email, String senha, List<EmprestimoResponseDTO> emprestimos ) {
}
