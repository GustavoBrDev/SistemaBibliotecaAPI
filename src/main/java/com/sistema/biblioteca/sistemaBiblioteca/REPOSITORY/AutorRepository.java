package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor, Integer > {

    /**
     * Returns whether an Autor entity with the given nome exists.
     *
     * @param nome nome of the Autor to search for
     * @return true if an Autor with the given nome exists, false otherwise
     */
    public boolean existsByNome ( String nome );
}
