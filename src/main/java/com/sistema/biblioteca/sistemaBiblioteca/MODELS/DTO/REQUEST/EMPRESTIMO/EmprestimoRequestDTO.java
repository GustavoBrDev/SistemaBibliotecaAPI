package com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO.UsuarioRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Emprestimo;


public record EmprestimoRequestDTO(String dataInicio, String dataDevolucao, Float valorMulta, Boolean devolvido, LivroRequestDTO livro, UsuarioRequestDTO usuario) {

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
