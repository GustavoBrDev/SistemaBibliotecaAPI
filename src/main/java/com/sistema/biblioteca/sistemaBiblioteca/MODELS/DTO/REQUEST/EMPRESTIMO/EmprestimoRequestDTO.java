package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO.UsuarioRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Emprestimo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Record de DTO para o recurso de emprestimos.
 * Utilizado para criar um novo emprestimo.
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @param dataInicio data de inicio do emprestimo a ser criado
 * @param dataDevolucao data de devolucao do emprestimo a ser criado
 * @param valorMulta valor da multa a ser cobrada para o emprestimo a ser criado (opcional)
 * @param devolvido status de devolucao do emprestimo a ser criado
 * @param livro livro a ser emprestado
 * @param usuario usuario que solicitou o emprestimo
 */
public record EmprestimoRequestDTO(@NotBlank String dataInicio, @NotBlank String dataDevolucao, @Positive Float valorMulta, @NotNull Boolean devolvido, @NotNull LivroRequestDTO livro, @NotNull UsuarioRequestDTO usuario) {

    public Emprestimo converter() {
        return Emprestimo.builder().
                dataInicio(this.dataInicio).
                dataDevolucao(this.dataDevolucao).
                valorMulta(this.valorMulta).
                devolvido(this.devolvido).
                livro(this.livro.converter()).
                usuario(this.usuario.converter()).
                build();
    }
}
