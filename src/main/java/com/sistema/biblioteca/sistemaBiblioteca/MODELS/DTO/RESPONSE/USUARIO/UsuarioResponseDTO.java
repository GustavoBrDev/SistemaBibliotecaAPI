package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO;

import lombok.Builder;

/**
 * Record de DTO para o recurso de usuarios.
 * Utilizado para retornar as informacoes de um usuario sem os emprestimos.
 * @param id id do usuario
 * @param nome nome do usuario
 * @param email email do usuario
 * @param senha senha do usuario
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
@Builder
public record UsuarioResponseDTO( Integer id, String nome, String email, String senha ) {
}
