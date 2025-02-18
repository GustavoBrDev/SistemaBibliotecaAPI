package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import lombok.Builder;

/**
 * Record de DTO para o recurso de emprestimos.
 * Utilizado para retornar as informacoes de um emprestimo sem o usuario.
 * @param id id do emprestimo
 * @param dataInicio data de inicio do emprestimo
 * @param dataDevolucao data de devolucao do emprestimo
 * @param valorMulta valor da multa do emprestimo
 * @param devolvido booleano indicando se o emprestimo foi devolvido
 * @param livro livro a ser emprestado em forma de {@link LivroFullResponseDTO}
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @see LivroFullResponseDTO
 */
@Builder
public record EmprestimoResponseDTO( Integer id, String dataInicio, String dataDevolucao, Float valorMulta, Boolean devolvido, LivroFullResponseDTO livro ) {
}
