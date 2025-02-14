package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO.GeneroPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO.GeneroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO.GeneroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Genero;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.GeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
        public class GeneroService {

        private GeneroRepository repository;

        /**
        * Creates a new genre in the repository.
        *
        * @param generoRequestDTO The data transfer object containing the genre details.
        * @return The newly created genre's full response data transfer object.
        * @throws RuntimeException if a genre with the same name already exists.
        */
        public GeneroFullResponseDTO criarGenero (GeneroRequestDTO generoRequestDTO) {

            Genero genero = generoRequestDTO.converter();

            if ( repository.existsByNome(genero.getNome()) ) {
                throw new RuntimeException("Genero já cadastrado");
            }

            return repository.save( genero ).converterTudo();
        }


        /**
         * Updates an existing genre in the repository.
         *
         * @param id The unique identifier of the genre to be updated.
         * @param generoPutRequestDTO The data transfer object containing the updated genre details.
         * @return The updated genre's full response data transfer object.
         * @throws RuntimeException if a genre with the given ID does not exist.
         */
        public GeneroFullResponseDTO atualizarGenero (Integer id, GeneroPutRequestDTO generoPutRequestDTO) {

        if ( repository.existsById(id) ) {
            Genero genero = generoPutRequestDTO.converter();
            genero.setId(id);
            return repository.save(genero).converterTudo();
        }

        throw new RuntimeException("Genero não encontrado");
    }

    /**
     * Retrieves a genre by its unique identifier from the repository.
     *
     * @param id The unique identifier of the genre to retrieve.
     * @return The full response data transfer object of the found genre.
     * @throws RuntimeException if a genre with the given ID does not exist.
     */
    public GeneroFullResponseDTO buscarGenero ( Integer id ) {

        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Genero não encontrado");
        }
    }

    /**
     * Retrieves a list of all genres from the repository.
     *
     * @return A list of GeneroFullResponseDTO objects representing all genres.
     * @throws RuntimeException if there is an error retrieving the genres.
     */
    public List<GeneroFullResponseDTO> listarGeneros () {

        try {
            return repository.findAll().stream().map(Genero::converterTudo).toList();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Genero não encontrado");
        }
    }

    /**
     * Deletes a genre by its unique identifier from the repository.
     *
     * @param id The unique identifier of the genre to delete.
     * @throws RuntimeException if a genre with the given ID does not exist.
     */
    public void deletarGenero ( Integer id ) {

        if ( repository.existsById(id) ) {
            repository.deleteById(id);
        }

        throw new RuntimeException("Genero não encontrado");
    }
}
