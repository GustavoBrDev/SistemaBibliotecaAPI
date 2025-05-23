package com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO.EmprestimoFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO.EmprestimoResponseDTO;
import jakarta.persistence.*;
import lombok.*;

/**
 * Classe que representa um emprestimo
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY )
    private Integer id;

    @NonNull
    @Column ( nullable = false )
    private String dataInicio;

    @NonNull
    @Column ( nullable = false )
    private String dataDevolucao;

    private Float valorMulta;

    @NonNull
    @Column ( nullable = false )
    private Boolean devolvido;

    @ManyToOne
    @NonNull
    @JoinColumn ( nullable = false )
    private Livro livro;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Usuario usuario;

    public EmprestimoResponseDTO converter() {
        return EmprestimoResponseDTO.builder().
                id(this.id).
                dataInicio(this.dataInicio).
                dataDevolucao(this.dataDevolucao).
                valorMulta(this.valorMulta).
                devolvido(this.devolvido).
                livro(this.livro.converterTudo()).
                build();
    }

    public EmprestimoFullResponseDTO converterTudo() {
        return EmprestimoFullResponseDTO.builder().
                id(this.id).
                dataInicio(this.dataInicio).
                dataDevolucao(this.dataDevolucao).
                valorMulta(this.valorMulta).
                devolvido(this.devolvido).
                livro(this.livro.converterTudo()).
                usuario(this.usuario.converter()).
                build();
    }
}