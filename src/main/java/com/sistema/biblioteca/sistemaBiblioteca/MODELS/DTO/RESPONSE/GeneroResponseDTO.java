package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE;

import lombok.Builder;

@Builder
public record GeneroResponseDTO(
        Integer id,
        String nome,
        String descricao ) {

    public GeneroResponseDTO converter () {
        return GeneroResponseDTO.builder()
                .id ( this.id )
                .descricao( this.descricao )
                .nome ( this.nome )
                .build();
    }
}
