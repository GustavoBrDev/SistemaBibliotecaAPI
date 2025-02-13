package com.sistema.biblioteca.sistemaBiblioteca.CONTROLLER;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.LivroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.LivroFullResponseDTO;
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

    @PostMapping
    public ResponseEntity<LivroFullResponseDTO> criarLivro ( @RequestBody @Valid LivroRequestDTO livroRequestDTO ) {

        try {
            LivroFullResponseDTO livroFullResponseDTO = service.criarLivro( livroRequestDTO );
            return new ResponseEntity<>( livroFullResponseDTO, HttpStatus.CREATED );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping
    public ResponseEntity<LivroFullResponseDTO> atualizarLivro ( @RequestBody @Valid LivroRequestDTO livroRequestDTO, @RequestParam Integer id ) {

        try {
            LivroFullResponseDTO livroFullResponseDTO = service.atualizarLivro( livroRequestDTO, id );
            return new ResponseEntity<>( livroFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<LivroFullResponseDTO> buscarLivro ( @PathVariable @Positive Integer id ) {

        try {
            LivroFullResponseDTO livroFullResponseDTO = service.buscarLivro( id );
            return new ResponseEntity<>( livroFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<List<LivroFullResponseDTO>> listarLivros () {
        return new ResponseEntity<>( service.listarLivros(), HttpStatus.OK );
    }

}
