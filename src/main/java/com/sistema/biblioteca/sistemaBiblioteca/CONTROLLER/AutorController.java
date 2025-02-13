package com.sistema.biblioteca.sistemaBiblioteca.CONTROLLER;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.AUTOR.AutorPullRequestDTO;
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

    @PostMapping
    public ResponseEntity<AutorFullResponseDTO> criarAutor ( @RequestBody @Valid AutorRequestDTO autorRequestDTO ) {
        try {
            AutorFullResponseDTO autorFullResponseDTO = service.criarAutor( autorRequestDTO );
            return new ResponseEntity<>( autorFullResponseDTO, HttpStatus.CREATED );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorFullResponseDTO> atualizarAutor (@RequestBody @Valid AutorPullRequestDTO autorPullRequestDTO, @PathVariable @Positive Integer id ) {
        try {
            AutorFullResponseDTO autorFullResponseDTO = service.atualizarAutor( autorPullRequestDTO, id );
            return new ResponseEntity<>( autorFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<List<AutorFullResponseDTO>> listarAutores () {
        try {
            return new ResponseEntity<>( service.listarAutores(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorFullResponseDTO> buscarAutor ( @PathVariable @Positive Integer id ) {
        try {
            AutorFullResponseDTO autorFullResponseDTO = service.buscarAutor( id );
            return new ResponseEntity<>( autorFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

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
