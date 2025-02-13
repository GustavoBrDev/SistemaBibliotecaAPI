package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record AutorResponseDTO(Integer id, String nome, String dataNascimento, String biografia) {
}
