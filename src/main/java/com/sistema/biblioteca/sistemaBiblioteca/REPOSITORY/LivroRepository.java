package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository <Livro, Integer> {

    /**
     * Retrieves a list of books that have been borrowed if the given emprestado value is true, or a list of books that have not been borrowed if the given emprestado value is false.
     *
     * @param emprestado true if the book has been borrowed, false if the book has not been borrowed
     * @return a list of books
     */
    public List<Livro> findByEmprestado ( boolean emprestado );

}
