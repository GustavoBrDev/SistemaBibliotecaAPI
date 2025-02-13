package com.sistema.biblioteca.sistemaBiblioteca.CONTROLLER;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO.GeneroPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO.GeneroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO.GeneroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.SERVICE.GeneroService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
@AllArgsConstructor
public class GeneroController {

    private GeneroService service;

    @PostMapping
    public ResponseEntity<GeneroFullResponseDTO> criarGenero ( @RequestBody @Valid GeneroRequestDTO generoRequestDTO ) {
        try {
            GeneroFullResponseDTO generoFullResponseDTO = service.criarGenero( generoRequestDTO );
            return new ResponseEntity<>( generoFullResponseDTO, HttpStatus.CREATED );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }


    @PutMapping
    public ResponseEntity<GeneroFullResponseDTO> atualizarGenero (@RequestBody @Valid GeneroPutRequestDTO generoPutRequestDTO, @RequestParam Integer id ) {
        try {
            GeneroFullResponseDTO generoFullResponseDTO = service.atualizarGenero( id, generoPutRequestDTO);
            return new ResponseEntity<>( generoFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<List<GeneroFullResponseDTO>> listarGeneros () {
        try {
            return new ResponseEntity<>( service.listarGeneros(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroFullResponseDTO> buscarGenero ( @PathVariable @Positive Integer id ) {
        try {
            GeneroFullResponseDTO generoFullResponseDTO = service.buscarGenero( id );
            return new ResponseEntity<>( generoFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGenero ( @PathVariable @Positive Integer id ) {
        try {
            service.deletarGenero( id );
            return new ResponseEntity<>( HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

}
