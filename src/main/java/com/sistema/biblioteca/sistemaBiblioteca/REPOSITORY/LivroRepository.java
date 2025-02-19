package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository para o recurso de livros.
 * @see Livro
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
public interface LivroRepository extends JpaRepository <Livro, Integer> {

    /**
     * Método que busca livros por status de emprestimo.
     * @param emprestado booleano indicando se o livro foi emprestado
     * @return lista de livros
     */
    public List<Livro> findByEmprestado ( boolean emprestado );

}
