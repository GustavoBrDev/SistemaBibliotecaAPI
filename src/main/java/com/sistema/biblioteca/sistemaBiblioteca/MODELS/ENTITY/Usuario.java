package com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO.EmprestimoResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO.UsuarioFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO.UsuarioResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
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

    public UsuarioFullResponseDTO converterTudo() {
        return UsuarioFullResponseDTO.builder()
                .id(this.id)
                .nome(this.nome)
                .email(this.email)
                .emprestimos(this.converterEmprestimos())
                .build();
    }

    public UsuarioResponseDTO converter() {
        return UsuarioResponseDTO.builder()
                .id(this.id)
                .nome(this.nome)
                .email(this.email)
                .build();
    }

    public List<EmprestimoResponseDTO> converterEmprestimos() {

        List<EmprestimoResponseDTO> conversao = new ArrayList<>();

        for ( Emprestimo emprestimo : this.emprestimos ) {
            conversao.add( emprestimo.converter() );
        }

        return conversao;
    }
}
