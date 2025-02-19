package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository para o recurso de generos.
 * @see Genero
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
public interface GeneroRepository extends JpaRepository<Genero, Integer > {

    /**
     * Verifica se existe um g nero com o nome especificado.
     *
     * @param nome nome do g nero
     * @return true se o g nero existe, false caso contr rio
     */
    public boolean existsByNome ( String nome );
}
