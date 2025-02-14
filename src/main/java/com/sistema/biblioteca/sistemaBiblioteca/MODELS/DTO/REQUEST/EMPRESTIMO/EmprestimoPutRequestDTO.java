package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO.UsuarioRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Emprestimo;

public record EmprestimoPutRequestDTO(Integer id, String dataDevolucao, String dataInicio, Float valorMulta, Boolean devolvido, LivroRequestDTO livro, UsuarioRequestDTO usuario) {

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
