package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Integer > {

    /**
     * Verifica se existe um g nero com o nome especificado.
     *
     * @param nome nome do g nero
     * @return true se o g nero existe, false caso contr rio
     */
    public boolean existsByNome ( String nome );
}
