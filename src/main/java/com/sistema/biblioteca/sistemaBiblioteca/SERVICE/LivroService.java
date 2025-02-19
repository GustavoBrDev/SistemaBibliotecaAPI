package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroPutRequestDto;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Livro;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço para o recurso de livros.
 * @see LivroRepository, Livro
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
@Service
@AllArgsConstructor
public class LivroService {

    /**
     * Repositório de livros
     * @see LivroRepository
     */
    private LivroRepository repository;

    public LivroFullResponseDTO criarLivro (LivroRequestDTO livroRequestDTO ){

        Livro livro = livroRequestDTO.converter();

        return repository.save( livro ).converterTudo();

    }

    /**
     * Método para buscar um livro
     * @param id ID do livro
     * @return O livro buscado em forma de {@link LivroFullResponseDTO}
     * @see LivroFullResponseDTO
     */
    public LivroFullResponseDTO buscarLivro ( Integer id ){

        return repository.findById( id ).get().converterTudo();
    }

    /**
     * Metodo para listar todos os livros existentes
     * @return A lista de livros em forma de {@link LivroFullResponseDTO}
     * @see LivroFullResponseDTO
     */
    public List<LivroFullResponseDTO> listarLivros () {
        return repository.findAll().stream().map(Livro::converterTudo).toList();
    }

    /**
     * Metodo para listar todos os livros disponiveis
     * @return A lista de livros disponiveis em forma de {@link LivroFullResponseDTO}
     * @see LivroFullResponseDTO
     */
    public List<LivroFullResponseDTO> listarLivrosDisponiveis () {
        return repository.findByEmprestado(false).stream().map(Livro::converterTudo).toList();
    }

    /**
     * Metodo para listar todos os livros emprestados
     * @return A lista de livros emprestados em forma de {@link LivroFullResponseDTO}
     * @see LivroFullResponseDTO
     */
    public List<LivroFullResponseDTO> listarLivrosEmprestados () {
        return repository.findByEmprestado(true).stream().map(Livro::converterTudo).toList();
    }

    /**
     * Metodo para atualizar um livro
     * @param livroPutRequestDto O {@link LivroPutRequestDto} contendo os dados atualizados do livro
     * @param id O ID do livro a ser atualizado
     * @return O livro atualizado em forma de {@link LivroFullResponseDTO}
     * @see LivroPutRequestDto, LivroFullResponseDTO
     */
    public LivroFullResponseDTO atualizarLivro (LivroPutRequestDto livroPutRequestDto, Integer id ){

        Livro livro = livroPutRequestDto.converter();

        if ( !repository.existsById(id) ){
            livro.setId(id);
            return repository.save( livroPutRequestDto.converter() ).converterTudo();
        }

        throw new RuntimeException("Livro não encontrado");
    }

    /**
     * Metodo para emprestar um livro
     * @param id O ID do livro a ser emprestado
     */
    public void emprestarLivro ( Integer id ){

        if ( repository.existsById(id) ){
            Livro livro = repository.findById(id).get();
            livro.setEmprestado(true);
            repository.save(livro);
        }

        throw new RuntimeException("Livro não encontrado");
    }

    /**
     * Metodo para devolver um livro
     * @param id O ID do livro a ser devolvido
     */
    public void devolverLivro ( Integer id ){

        if ( repository.existsById(id) ){
            Livro livro = repository.findById(id).get();
            livro.setEmprestado(false);
            repository.save(livro);
        }
    }

    /**
     * Metodo para deletar um livro
     * @param id O ID do livro a ser deletado
     */
    public void deletarLivro ( Integer id ){

        if ( repository.existsById(id) ){
            repository.deleteById( id );
        }

        throw new RuntimeException("Livro não encontrado");
    }
}
