package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO.UsuarioResponseDTO;
import lombok.Builder;

/**
 * Record de DTO para o recurso de emprestimos.
 * Utilizado para retornar TODAS as informacoes de um emprestimo.
 * @param id id do emprestimo
 * @param dataInicio data de inicio do emprestimo
 * @param dataDevolucao data de devolucao do emprestimo
 * @param valorMulta valor da multa do emprestimo
 * @param devolvido status de devolucao do emprestimo
 * @param livro livro a ser emprestado em forma de {@link LivroFullResponseDTO}
 * @param usuario usuario que emprestou o livro em forma de {@link UsuarioResponseDTO}
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @see LivroFullResponseDTO, UsuarioResponseDTO
 */
@Builder
public record EmprestimoFullResponseDTO(Integer id, String dataInicio, String dataDevolucao, Float valorMulta, Boolean devolvido, LivroFullResponseDTO livro, UsuarioResponseDTO usuario) {
}
