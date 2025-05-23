package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO;

import lombok.Builder;

/**
 * Record de DTO para o recurso de genero.
 * Utilizado para retornar as informacoes do genero sem os livros.
 * @param id id do genero
 * @param nome nome do genero
 * @param descricao descricao do genero
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
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
