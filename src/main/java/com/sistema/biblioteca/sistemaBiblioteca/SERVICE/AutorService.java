package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

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

    public AutorFullResponseDTO criarAutor (AutorRequestDTO autorRequestDTO ) {

        Autor autor = autorRequestDTO.converter();

        if ( repository.existsByNome(autor.getNome()) ) {
            throw new RuntimeException("Autor já cadastrado");
        }

        return repository.save( autor ).converterTudo();
    }

    public AutorFullResponseDTO atualizarAutor (AutorRequestDTO autorRequestDTO, Integer id) {

        Autor autor = autorRequestDTO.converter();
        autor.setId( id );

        if ( repository.existsById(id) ) {
            return repository.save( autor ).converterTudo();
        }

        throw new RuntimeException("Autor não encontrado");
    }

    public AutorFullResponseDTO buscarAutor ( Integer id ) {

        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Autor não encontrado");
        }

    }

    public List<AutorFullResponseDTO> listarAutores () {
        return repository.findAll().stream().map(Autor::converterTudo).toList();
    }

    public void deletarAutor ( Integer id ) {

        if ( repository.existsById(id) ) {
            repository.deleteById(id);
        }

        throw new RuntimeException("Autor não encontrado");
    }
}
