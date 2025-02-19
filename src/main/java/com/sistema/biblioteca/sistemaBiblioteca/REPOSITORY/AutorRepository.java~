package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository para o recurso de autores.
 * @see Autor
 */
public interface AutorRepository extends JpaRepository <Autor, Integer > {

    /**
     * Método que verifica se existe um autor com o mesmo nome
     * @param nome nome do autor a ser verificado
     * @return true se o autor existir, false caso contr rio
     */
    public boolean existsByNome ( String nome );
}
