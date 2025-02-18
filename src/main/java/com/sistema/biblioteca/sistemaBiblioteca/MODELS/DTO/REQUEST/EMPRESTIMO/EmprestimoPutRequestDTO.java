package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO.UsuarioRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Emprestimo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Record de DTO para o recurso de emprestimos.
 * Utilizado para atualização de emprestimos.
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @param id id do emprestimo a ser atualizado
 * @param dataDevolucao data de devolucao do emprestimo a ser atualizado
 * @param dataInicio data de inicio do emprestimo a ser atualizado
 * @param valorMulta valor da multa do emprestimo a ser atualizado (opcional)
 * @param devolvido booleano indicando se o emprestimo foi devolvido
 * @param livro livro a ser emprestado
 * @param usuario usuario que emprestou o livro
 */
public record EmprestimoPutRequestDTO(@NotNull @Positive Integer id, @NotBlank String dataDevolucao, @NotBlank String dataInicio, Float valorMulta, @NotNull Boolean devolvido, @Valid LivroRequestDTO livro, @Valid UsuarioRequestDTO usuario) {

    public Emprestimo converter() {
        return Emprestimo.builder().
                id(this.id).
                dataDevolucao(this.dataDevolucao).
                dataInicio(this.dataInicio).
                valorMulta(this.valorMulta).
                devolvido(this.devolvido).
                livro(this.livro.converter()).
                usuario(this.usuario.converter()).
                build();
    }
}
