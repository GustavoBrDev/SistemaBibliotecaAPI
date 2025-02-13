package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository <Livro, Integer> {

    public List<Livro> findByEmprestado ( boolean emprestado );

}
