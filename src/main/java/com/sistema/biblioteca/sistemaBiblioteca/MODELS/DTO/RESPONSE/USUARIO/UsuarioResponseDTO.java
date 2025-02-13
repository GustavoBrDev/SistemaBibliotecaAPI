package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO;

import lombok.Builder;

@Builder
public record UsuarioResponseDTO( Integer id, String nome, String email, String senha ) {
}
