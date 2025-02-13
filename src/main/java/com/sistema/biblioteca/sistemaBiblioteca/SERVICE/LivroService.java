package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroPullRequestDto;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LivroService {

    private LivroRepository repository;

    public LivroFullResponseDTO criarLivro (LivroRequestDTO livroRequestDTO ){

        Livro livro = livroRequestDTO.converter();

        return repository.save( livro ).converterTudo();

    }

    public LivroFullResponseDTO buscarLivro ( Integer id ){

        return repository.findById( id ).get().converterTudo();
    }

    public List<LivroFullResponseDTO> listarLivros () {
        return repository.findAll().stream().map(Livro::converterTudo).toList();
    }

    public List<LivroFullResponseDTO> listarLivrosDisponiveis () {
        return repository.findByEmprestado(false).stream().map(Livro::converterTudo).toList();
    }

    public List<LivroFullResponseDTO> listarLivrosEmprestados () {
        return repository.findByEmprestado(true).stream().map(Livro::converterTudo).toList();
    }

    public LivroFullResponseDTO atualizarLivro (LivroPullRequestDto livroPullRequestDto, Integer id ){

        if ( !repository.existsById(id) ){
            livroPullRequestDto.setId(id);
            return repository.save( livroPullRequestDto.converter() ).converterTudo();
        }

        throw new RuntimeException("Livro não encontrado");
    }

    public void deletarLivro ( Integer id ){

        if ( repository.existsById(id) ){
            repository.deleteById( id );
        }

        throw new RuntimeException("Livro não encontrado");
    }
}
