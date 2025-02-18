package com.sistema.biblioteca.sistemaBiblioteca.CONTROLLER;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR.AutorPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR.AutorRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO.EmprestimoRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR.AutorFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.SERVICE.AutorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe de controle para o recurso de autores.
 * @see AutorService, Autor
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */

@RestController
@RequestMapping("/autores")
@AllArgsConstructor
public class AutorController {

    /**
     * O serviço de autor que realiza as operações de criação, atualização, listagem e exclusão de autores.
     * @see AutorService
     */
    private AutorService service;

    /**
     * Método de POST para criar um autor.
     * @param autorRequestDTO O {@link EmprestimoRequestDTO} a ser criado
     * @return Um ResponseEntity contendo o autor criado e o status HTTP 201 (Created) ou o status HTTP 400 (Bad Request).
     * @see AutorService#criarAutor(AutorRequestDTO), AutorFullResponseDTO
     */

    @PostMapping
    public ResponseEntity<AutorFullResponseDTO> criarAutor ( @RequestBody @Valid AutorRequestDTO autorRequestDTO ) {
        try {
            AutorFullResponseDTO autorFullResponseDTO = service.criarAutor( autorRequestDTO );
            return new ResponseEntity<>( autorFullResponseDTO, HttpStatus.CREATED );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Método de PUT para atualizar um autor.
     * @param autorPutRequestDTO O {@link AutorPutRequestDTO} contendo os dados atualizados do autor.
     * @param id O ID do autor a ser atualizado.
     * @return Um ResponseEntity contendo o autor atualizado e o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
     * @see AutorService#atualizarAutor(AutorPutRequestDTO, Integer), AutorFullResponseDTO
     */
    @PutMapping("/{id}")
    public ResponseEntity<AutorFullResponseDTO> atualizarAutor (@RequestBody @Valid AutorPutRequestDTO autorPutRequestDTO, @PathVariable @Positive Integer id ) {
        try {
            AutorFullResponseDTO autorFullResponseDTO = service.atualizarAutor(autorPutRequestDTO, id );
            return new ResponseEntity<>( autorFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Método de GET para listar todos os autores.
     * @return Um ResponseEntity contendo uma lista de autores e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see AutorService#listarAutores(), List<AutorFullResponseDTO>
     */
    @GetMapping
    public ResponseEntity<List<AutorFullResponseDTO>> listarAutores () {
        try {
            return new ResponseEntity<>( service.listarAutores(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Método GET para buscar um autor pelo ID.
     * @param id O ID do autor a ser buscado.
     * @return Um ResponseEntity contendo o autor e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see AutorService#buscarAutor(Integer), AutorFullResponseDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<AutorFullResponseDTO> buscarAutor ( @PathVariable @Positive Integer id ) {
        try {
            AutorFullResponseDTO autorFullResponseDTO = service.buscarAutor( id );
            return new ResponseEntity<>( autorFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Método DELETE para deletar um autor pelo ID.
     * @param id O ID do autor a ser deletado.
     * @return Um ResponseEntity contendo o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
     * @see AutorService#deletarAutor(Integer)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor ( @PathVariable @Positive Integer id ) {
        try {
            service.deletarAutor( id );
            return new ResponseEntity<>( HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
