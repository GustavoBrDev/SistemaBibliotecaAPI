package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR.AutorPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR.AutorRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR.AutorFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Autor;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AutorService {

    private AutorRepository repository;

    /**
     * Creates a new author and returns the created author with full details.
     *
     * @param autorRequestDTO The author details to be created.
     * @return The created author's full response DTO.
     * @throws RuntimeException if an author with the same name already exists.
     */
    public AutorFullResponseDTO criarAutor (AutorRequestDTO autorRequestDTO ) {

        Autor autor = autorRequestDTO.converter();

        if ( repository.existsByNome(autor.getNome()) ) {
            throw new RuntimeException("Autor já cadastrado");
        }

        return repository.save( autor ).converterTudo();
    }

    /**
     * Updates an existing author and returns the updated author with full details.
     *
     * @param autorRequestDTO The updated author details.
     * @param id              The ID of the author to be updated.
     * @return The updated author's full response DTO.
     * @throws RuntimeException if the author with the given ID does not exist.
     */
    public AutorFullResponseDTO atualizarAutor (AutorPutRequestDTO autorRequestDTO, Integer id) {

        if ( repository.existsById(id) ) {
            Autor autor = autorRequestDTO.converter();
            autor.setId( id );
            return repository.save( autor ).converterTudo();
        }

        throw new RuntimeException("Autor não encontrado");
    }

    /**
     * Retrieves an author by their ID and returns the author's full details.
     *
     * @param id The ID of the author to be retrieved.
     * @return The author's full response DTO.
     * @throws RuntimeException if the author with the given ID does not exist.
     */
    public AutorFullResponseDTO buscarAutor ( Integer id ) {

        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Autor não encontrado");
        }

    }

    /**
     * Retrieves a list of all authors.
     *
     * @return A list of full response DTOs of all authors.
     */
    public List<AutorFullResponseDTO> listarAutores () {
        return repository.findAll().stream().map(Autor::converterTudo).toList();
    }

    /**
     * Deletes an author by their ID.
     *
     * @param id The ID of the author to be deleted.
     * @throws RuntimeException if the author with the given ID does not exist.
     */
    public void deletarAutor ( Integer id ) {

        if ( repository.existsById(id) ) {
            repository.deleteById(id);
        }

        throw new RuntimeException("Autor não encontrado");
    }
}
