package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO.GeneroPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO.GeneroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO.GeneroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Genero;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.GeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço para o recurso de generos.
 * @see GeneroRepository, Genero
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
@Service
@AllArgsConstructor
public class GeneroService {

    /**
     * Repositório de generos
     * @see GeneroRepository
     */
    private GeneroRepository repository;

    /**
     * Método para criar um novo genero
     * @param generoRequestDTO A {@link GeneroRequestDTO} contendo os dados do genero
     * @return Um {@link GeneroFullResponseDTO} contendo o genero criado
     * @see GeneroFullResponseDTO, GeneroRequestDTO
     */
    public GeneroFullResponseDTO criarGenero (GeneroRequestDTO generoRequestDTO) {

        Genero genero = generoRequestDTO.converter();

        if ( repository.existsByNome(genero.getNome()) ) {
            throw new RuntimeException("Genero já cadastrado");
        }

        return repository.save( genero ).converterTudo();
    }

    /**
     * Método para atualizar um genero
     * @param id id do genero
     * @param generoPutRequestDTO A {@link GeneroPutRequestDTO} contendo os dados do genero
     * @return Um {@link GeneroFullResponseDTO} contendo o genero atualizado
     * @see GeneroFullResponseDTO, GeneroPutRequestDTO
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
     * Método para buscar um genero
     * @param id id do genero
     * @return Um {@link GeneroFullResponseDTO} contendo o genero buscado
     * @see GeneroFullResponseDTO
     */
    public GeneroFullResponseDTO buscarGenero ( Integer id ) {

        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Genero não encontrado");
        }
    }

    /**
     * Método para listar todos os generos
     * @return Uma lista de {@link GeneroFullResponseDTO} contendo todos os generos
     * @see GeneroFullResponseDTO
     */
    public List<GeneroFullResponseDTO> listarGeneros () {

        try {
            return repository.findAll().stream().map(Genero::converterTudo).toList();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Genero não encontrado");
        }
    }

    /**
     * Método para deletar um genero
     * @param id id do genero
     */
    public void deletarGenero ( Integer id ) {

        if ( repository.existsById(id) ) {
            repository.deleteById(id);
        }

        throw new RuntimeException("Genero não encontrado");
    }
}
