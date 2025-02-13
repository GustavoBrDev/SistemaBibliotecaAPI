package com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EmprestimoResponseDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
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
    private Boolean devolvido = false;

    @ManyToOne
    @NonNull
    @JoinColumn ( nullable = false )
    private Livro livro;

    @ManyToOne
    @NonNull
    @JoinColumn ( nullable = false )
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
}