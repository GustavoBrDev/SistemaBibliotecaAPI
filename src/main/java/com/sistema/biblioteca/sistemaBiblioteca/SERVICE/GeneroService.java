package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO.GeneroPullRequestDTO;
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

    public GeneroFullResponseDTO criarGenero (GeneroRequestDTO generoRequestDTO) {

        Genero genero = generoRequestDTO.converter();

        if ( repository.existsByNome(genero.getNome()) ) {
            throw new RuntimeException("Genero já cadastrado");
        }

        return repository.save( genero ).converterTudo();
    }


    public GeneroFullResponseDTO atualizarGenero (Integer id, GeneroPullRequestDTO generoPullRequestDTO ) {

        if ( repository.existsById(id) ) {
            Genero genero = generoPullRequestDTO.converter();
            genero.setId(id);
            return repository.save(genero).converterTudo();
        }

        throw new RuntimeException("Genero não encontrado");
    }

    public GeneroFullResponseDTO buscarGenero ( Integer id ) {

        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Genero não encontrado");
        }
    }

    public List<GeneroFullResponseDTO> listarGeneros () {

        try {
            return repository.findAll().stream().map(Genero::converterTudo).toList();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Genero não encontrado");
        }
    }


    public void deletarGenero ( Integer id ) {

        if ( repository.existsById(id) ) {
            repository.deleteById(id);
        }

        throw new RuntimeException("Genero não encontrado");
    }
}
