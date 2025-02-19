package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository para o recurso de usuários.
 * @see Usuario
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
public interface UsuarioRepository extends JpaRepository <Usuario, Integer > {
}
