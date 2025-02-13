package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AutorRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Autor;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AutorService {

    private AutorRepository repository;

    public void criarAutor (AutorRequestDTO autorRequestDTO ) {

        Autor autor = autorRequestDTO.converter();

        if ( repository.existsByNome(autor.getNome()) ) {
            throw new RuntimeException("Autor já cadastrado");
        }

        repository.save( autor );
    }

    public void atualizarAutor (AutorRequestDTO autorRequestDTO, Integer id) {

        Autor autor = autorRequestDTO.converter();
        autor.setId( id );

        if ( repository.existsById(id) ) {
            repository.save( autor );
        }

        throw new RuntimeException("Autor não encontrado");
    }

    public Autor buscarAutor ( Integer id ) {

        try {
            return repository.findById( id ).get();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Autor não encontrado");
        }

    }

    public List<Autor> listarAutores () {
        return repository.findAll();
    }

    public void deletarAutor ( Integer id ) {

        if ( repository.existsById(id) ) {
            repository.deleteById(id);
        }

        throw new RuntimeException("Autor não encontrado");
    }
}
