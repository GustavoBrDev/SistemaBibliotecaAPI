package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroPutRequestDto;
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

    /**
     * Creates a new book in the database.
     * @param livroRequestDTO the information of the book to be created
     * @return a response entity containing the created book
     */
    public LivroFullResponseDTO criarLivro (LivroRequestDTO livroRequestDTO ){

        Livro livro = livroRequestDTO.converter();

        return repository.save( livro ).converterTudo();

    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to be retrieved
     * @return a response entity containing the book details
     */
    public LivroFullResponseDTO buscarLivro ( Integer id ){

        return repository.findById( id ).get().converterTudo();
    }

    /**
     * Retrieves a list of all books.
     * @return a list of book details
     */
    public List<LivroFullResponseDTO> listarLivros () {
        return repository.findAll().stream().map(Livro::converterTudo).toList();
    }

    /**
     * Retrieves a list of books that are available to be borrowed.
     *
     * @return a list of book details
     */
    public List<LivroFullResponseDTO> listarLivrosDisponiveis () {
        return repository.findByEmprestado(false).stream().map(Livro::converterTudo).toList();
    }

    /**
     * Retrieves a list of all books that have been borrowed.
     *
     * @return a list of book details
     */
    public List<LivroFullResponseDTO> listarLivrosEmprestados () {
        return repository.findByEmprestado(true).stream().map(Livro::converterTudo).toList();
    }

    /**
     * Updates an existing book and returns the updated book.
     * @param livroPutRequestDto the updated book
     * @param id the ID of the book to be updated
     * @return a response entity containing the updated book
     * @throws RuntimeException if the book is not found
     */
    public LivroFullResponseDTO atualizarLivro (LivroPutRequestDto livroPutRequestDto, Integer id ){

        if ( !repository.existsById(id) ){
            livroPutRequestDto.setId(id);
            return repository.save( livroPutRequestDto.converter() ).converterTudo();
        }

        throw new RuntimeException("Livro não encontrado");
    }

    /**
     * Marks the book with the given ID as borrowed.
     *
     * @param id the ID of the book to be marked as borrowed
     * @throws RuntimeException if the book is not found
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
     * Marks the book with the given ID as returned.
     *
     * @param id the ID of the book to be marked as returned
     * @throws RuntimeException if the book is not found
     */
    public void devolverLivro ( Integer id ){

        if ( repository.existsById(id) ){
            Livro livro = repository.findById(id).get();
            livro.setEmprestado(false);
            repository.save(livro);
        }
    }

    /**
     * Deletes the book with the given ID.
     * @param id the ID of the book to be deleted
     * @throws RuntimeException if the book is not found
     */
    public void deletarLivro ( Integer id ){

        if ( repository.existsById(id) ){
            repository.deleteById( id );
        }

        throw new RuntimeException("Livro não encontrado");
    }
}
