package com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY )
    private Integer id;

    @NonNull
    @Column ( nullable = false )
    private String nome;

    @NonNull
    @Column ( nullable = false )
    private String email;

    @NonNull
    @Column ( nullable = false )
    private String senha;

    @OneToMany
    private List<Emprestimo> emprestimos;
}
