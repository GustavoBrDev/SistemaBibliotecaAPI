package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor, Integer > {

    public boolean existsByNome ( String nome );
}
