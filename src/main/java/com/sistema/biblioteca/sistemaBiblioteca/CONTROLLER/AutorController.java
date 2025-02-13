package com.sistema.biblioteca.sistemaBiblioteca.CONTROLLER;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR.AutorPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR.AutorRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.AUTOR.AutorFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.SERVICE.AutorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
@AllArgsConstructor
public class AutorController {

    private AutorService service;

    /**
     * Creates a new author and returns the created author.
     * @param autorRequestDTO The author to be created.
     * @return The created author.
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
     * Updates an existing author and returns the updated author.
     * @param autorPutRequestDTO The updated author.
     * @param id The ID of the author to be updated.
     * @return The updated author.
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
     * Retrieves a list of all authors.
     * @return A ResponseEntity containing a list of AutorFullResponseDTO and an HTTP status code.
     * Returns HttpStatus.OK if the operation is successful, otherwise returns HttpStatus.BAD_REQUEST.
     */
    @GetMapping
    public ResponseEntity<List<AutorFullResponseDTO>> listarAutores () {
        try {
            return new ResponseEntity<>( service.listarAutores(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Retrieves an author by their ID.
     * @param id The ID of the author to be retrieved.
     * @return A ResponseEntity containing the retrieved author and an HTTP status code.
     * Returns HttpStatus.OK if the operation is successful, otherwise returns HttpStatus.BAD_REQUEST.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AutorFullResponseDTO> buscarAutor ( @PathVariable @Positive Integer id ) {
        try {
            AutorFullResponseDTO autorFullResponseDTO = service.buscarAutor( id );
            return new ResponseEntity<>( autorFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Deletes an author by their ID.
     * @param id The ID of the author to be deleted.
     * @return A ResponseEntity containing an HTTP status code.
     * Returns HttpStatus.OK if the operation is successful, otherwise returns HttpStatus.BAD_REQUEST.
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
