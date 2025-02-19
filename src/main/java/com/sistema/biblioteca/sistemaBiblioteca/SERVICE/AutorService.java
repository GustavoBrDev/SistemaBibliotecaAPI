package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR.AutorPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR.AutorRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR.AutorFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Autor;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Classe de serviço para o recurso de autores
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 * @see AutorRepository
 */
@AllArgsConstructor
@Service
public class AutorService {

    /**
     * Repository do recurso de autores
     */
    private AutorRepository repository;

    /**
     * Metodo para criar um autor
     * @param autorRequestDTO O {@link AutorRequestDTO} contendo os dados do autor
     * @return O autor criado em forma de {@link AutorFullResponseDTO}
     * @see Autor, AutorFullResponseDTO, AutorRequestDTO
     */
    public AutorFullResponseDTO criarAutor (AutorRequestDTO autorRequestDTO ) {

        Autor autor = autorRequestDTO.converter();

        if ( repository.existsByNome(autor.getNome()) ) {
            throw new RuntimeException("Autor já cadastrado");
        }

        return repository.save( autor ).converterTudo();
    }

    /**
     * Método para atualizar um autor
     * @param autorRequestDTO O {@link AutorPutRequestDTO} contendo os dados atualizados do autor
     * @param id O ID do autor a ser atualizado
     * @return O autor atualizado em forma de {@link AutorFullResponseDTO}
     * @see Autor, AutorFullResponseDTO, AutorPutRequestDTO
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
     * Método para buscar um autor
     * @param id O ID do autor a ser buscado
     * @return O autor buscado em forma de {@link AutorFullResponseDTO}
     * @see Autor, AutorFullResponseDTO
     */
    public AutorFullResponseDTO buscarAutor ( Integer id ) {

        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Autor não encontrado");
        }

    }

    /**
     * Método para listar todos os autores
     * @return Uma lista de todos os autores em forma de {@link AutorFullResponseDTO}
     * @see Autor, AutorFullResponseDTO
     */
    public List<AutorFullResponseDTO> listarAutores () {
        return repository.findAll().stream().map(Autor::converterTudo).toList();
    }

    /**
     * Método para deletar um autor
     * @param id O ID do autor a ser deletado
     * @see Autor
     */
    public void deletarAutor ( Integer id ) {

        if ( repository.existsById(id) ) {
            repository.deleteById(id);
        }

        throw new RuntimeException("Autor não encontrado");
    }
}
