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

/**
 * Classe de controle para o recurso de livros.
 * @see LivroService, Livro
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
@RestController
@RequestMapping("/livros")
@AllArgsConstructor
public class LivroController {

    /**
     * Serviço de livros que permite criar, atualizar, buscar, listar e deletar livros
     * @see LivroService
     */
    public LivroService service;

    /**
     * Método POST para criar um novo livro
     * @param livroRequestDTO A {@link LivroRequestDTO} contendo os dados do livro
     * @return Um ResponseEntity contendo o livro criado e o status HTTP 201 (Created) ou o status HTTP 400 (Bad Request).
     * @see LivroService#criarLivro(LivroRequestDTO), LivroRequestDTO, LivroFullResponseDTO
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
     * Método de PUT para atualizar um livro
     * @param livroPutRequestDto O {@link LivroPutRequestDto} contendo os dados atualizados do livro
     * @param id O ID do livro a ser atualizado
     * @return Um ResponseEntity contendo o livro atualizado e o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
     * @see LivroService#atualizarLivro(LivroPutRequestDto, Integer), LivroFullResponseDTO
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
     * Método GET para buscar um livro existente
     * @param id O ID do livro a ser buscado
     * @return Um ResponseEntity contendo o livro buscado e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see LivroService#buscarLivro(Integer), LivroFullResponseDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<LivroFullResponseDTO> buscarLivro ( @PathVariable @Positive Integer id ) {

        try {
            LivroFullResponseDTO livroFullResponseDTO = service.buscarLivro( id );
            return new ResponseEntity<>( livroFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Método GET para listar todos os livros existentes
     * @return Um ResponseEntity contendo a lista de livros e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see LivroService#listarLivros(), LivroFullResponseDTO
     */
    @GetMapping
    public ResponseEntity<List<LivroFullResponseDTO>> listarLivros () {
        try {
            return new ResponseEntity<>( service.listarLivros(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Método GET para listar todos os livros disponiveis
     * @return Um ResponseEntity contendo a lista de livros disponiveis e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see LivroService#listarLivrosDisponiveis(), LivroFullResponseDTO, Livro
     */
    @GetMapping("/disponiveis")
    public ResponseEntity<List<LivroFullResponseDTO>> listarLivrosDisponiveis () {
        try {
            return new ResponseEntity<>( service.listarLivrosDisponiveis(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Metodo GET para listar todos os livros emprestados
     * @return Um ResponseEntity contendo a lista de livros emprestados e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see LivroService#listarLivrosEmprestados(), LivroFullResponseDTO, Livro
     */
    @GetMapping("/emprestados")
    public ResponseEntity<List<LivroFullResponseDTO>> listarLivrosEmprestados () {
        try {
            return new ResponseEntity<>( service.listarLivrosEmprestados(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Metodo GET para listar todos os livros disponiveis ou emprestados
     * @return Um ResponseEntity contendo a lista de livros disponiveis ou emprestados e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see LivroService#listarLivrosDisponiveis(), LivroService#listarLivrosEmprestados(), LivroFullResponseDTO, Livro
     */
    @GetMapping
    public ResponseEntity<List<LivroFullResponseDTO>> listarLivrosPorDispobinilidade ( @RequestParam Boolean disponibilidade ) {

        try {
            return new ResponseEntity<>( disponibilidade ? service.listarLivrosDisponiveis() : service.listarLivrosEmprestados(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Metodo DELETE para deletar um livro pelo ID
     * @param id O ID do livro a ser deletado
     * @return Um ResponseEntity contendo o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
     * @see LivroService#deletarLivro(Integer)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro ( @PathVariable @Positive Integer id ) {
        service.deletarLivro( id );
        return new ResponseEntity<>( HttpStatus.OK );
    }

}
