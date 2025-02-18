package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR;

import lombok.Builder;

/**
 * Record de DTO para o recurso de autores.
 * Utilizado para retornar as informações do autor sem seus livros.
 * @param id id do autor
 * @param nome nome do autor
 * @param dataNascimento data de nascimento do autor
 * @param biografia biografia do autor
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
@Builder
public record AutorResponseDTO(Integer id, String nome, String dataNascimento, String biografia) {
}
