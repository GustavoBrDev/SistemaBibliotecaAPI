package com.sistema.biblioteca.sistemaBiblioteca.CONTROLLER;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroPutRequestDto;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LIVRO.LivroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LIVRO.LivroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.SERVICE.LivroService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@AllArgsConstructor
public class LivroController {

    public LivroService service;

    /**
     * Creates a new book.
     *
     * @param livroRequestDTO the information of the book to be created
     * @return a response entity with the created book
     * @throws RuntimeException if the creation fails
     */
    @PostMapping
    public ResponseEntity<LivroFullResponseDTO> criarLivro ( @RequestBody @Valid LivroRequestDTO livroRequestDTO ) {

        try {
            LivroFullResponseDTO livroFullResponseDTO = service.criarLivro( livroRequestDTO );
            return new ResponseEntity<>( livroFullResponseDTO, HttpStatus.CREATED );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Updates an existing book and returns the updated book.
     * @param livroPutRequestDto the updated book
     * @param id the ID of the book to be updated
     * @return a response entity with the updated book
     * @throws RuntimeException if the update fails
     */
    @PutMapping("/{id}")
    public ResponseEntity<LivroFullResponseDTO> atualizarLivro (@RequestBody @Valid LivroPutRequestDto livroPutRequestDto, @RequestParam Integer id ) {

        try {

            LivroFullResponseDTO livroFullResponseDTO = service.atualizarLivro(livroPutRequestDto, id );
            return new ResponseEntity<>( livroFullResponseDTO, HttpStatus.OK );

        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to be retrieved
     * @return a response entity containing the book details and HTTP status OK,
     *         or an HTTP status BAD_REQUEST if the book is not found
     * @throws RuntimeException if the retrieval fails
     */
    @GetMapping("/{id}")
    public ResponseEntity<LivroFullResponseDTO> buscarLivro ( @PathVariable @Positive Integer id ) {

        try {
            LivroFullResponseDTO livroFullResponseDTO = service.buscarLivro( id );
            return new ResponseEntity<>( livroFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Retrieves a list of all books.
     * @return a response entity containing a list of book details and HTTP status OK,
     *         or an HTTP status BAD_REQUEST if the retrieval fails
     * @throws RuntimeException if the retrieval fails
     */
    @GetMapping
    public ResponseEntity<List<LivroFullResponseDTO>> listarLivros () {
        try {
            return new ResponseEntity<>( service.listarLivros(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Retrieves a list of books that are available to be borrowed.
     *
     * @return a response entity containing a list of book details and HTTP status OK,
     *         or an HTTP status BAD_REQUEST if the retrieval fails
     * @throws RuntimeException if the retrieval fails
     */
    @GetMapping("/disponiveis")
    public ResponseEntity<List<LivroFullResponseDTO>> listarLivrosDisponiveis () {
        try {
            return new ResponseEntity<>( service.listarLivrosDisponiveis(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Retrieves a list of all books that have been borrowed.
     *
     * @return a response entity containing a list of book details and HTTP status OK,
     *         or an HTTP status BAD_REQUEST if the retrieval fails
     * @throws RuntimeException if the retrieval fails
     */
    @GetMapping("/emprestados")
    public ResponseEntity<List<LivroFullResponseDTO>> listarLivrosEmprestados () {
        try {
            return new ResponseEntity<>( service.listarLivrosEmprestados(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Retrieves a list of books that are either available or unavailable to be borrowed, based on the provided parameter.
     *
     * @param disponibilidade if true, returns a list of available books; if false, returns a list of unavailable books
     * @return a response entity containing a list of book details and HTTP status OK,
     *         or an HTTP status BAD_REQUEST if the retrieval fails
     * @throws RuntimeException if the retrieval fails
     */
    @GetMapping
    public ResponseEntity<List<LivroFullResponseDTO>> listarLivrosPorDispobinilidade ( @RequestParam Boolean disponibilidade ) {

        try {
            return new ResponseEntity<>( disponibilidade ? service.listarLivrosDisponiveis() : service.listarLivrosEmprestados(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Deletes a book by its ID.
     * @param id the ID of the book to be deleted
     * @return an HTTP status OK if the deletion is successful,
     *         or an HTTP status BAD_REQUEST if the deletion fails
     * @throws RuntimeException if the deletion fails
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro ( @PathVariable @Positive Integer id ) {
        service.deletarLivro( id );
        return new ResponseEntity<>( HttpStatus.OK );
    }

}
