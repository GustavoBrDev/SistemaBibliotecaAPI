package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Integer> {

}
