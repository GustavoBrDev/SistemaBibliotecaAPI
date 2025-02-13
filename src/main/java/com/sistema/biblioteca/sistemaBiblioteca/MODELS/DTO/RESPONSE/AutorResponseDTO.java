package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record AutorResponseDTO(@NonNull @PositiveOrZero Integer id, @NotBlank String nome, @NotBlank String dataNascimento, String biografia) {
}
