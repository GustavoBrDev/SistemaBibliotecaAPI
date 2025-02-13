package com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer > {
}
