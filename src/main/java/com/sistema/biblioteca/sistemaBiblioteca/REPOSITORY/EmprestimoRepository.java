package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de emprestimos
 * @see Emprestimo
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
public interface EmprestimoRepository extends JpaRepository <Emprestimo, Integer > {
}
