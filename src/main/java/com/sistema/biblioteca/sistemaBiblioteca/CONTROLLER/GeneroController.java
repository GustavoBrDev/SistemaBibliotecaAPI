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

/**
 * Classe de controle para o recurso de generos.
 * @see GeneroService, Genero
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
@RestController
@RequestMapping("/genero")
@AllArgsConstructor
public class GeneroController {

    /**
     * O serviço de genero que permite criar, atualizar, buscar, listar e deletar generos
     * @see GeneroService
     */
    private GeneroService service;

    /**
     * Método de POST para criar um novo genero
     * @param generoRequestDTO A {@link GeneroRequestDTO} contendo os dados do genero
     * @return Um ResponseEntity contendo o genero criado e o status HTTP 201 (Created) ou o status HTTP 400 (Bad Request).
     * @see GeneroService#criarGenero(GeneroRequestDTO), GeneroRequestDTO, GeneroFullResponseDTO
     */
    @PostMapping
    public ResponseEntity<GeneroFullResponseDTO> criarGenero ( @RequestBody @Valid GeneroRequestDTO generoRequestDTO ) {
        try {
            GeneroFullResponseDTO generoFullResponseDTO = service.criarGenero( generoRequestDTO );
            return new ResponseEntity<>( generoFullResponseDTO, HttpStatus.CREATED );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }


    /**
     * Método de PUT para atualizar um genero
     * @param generoPutRequestDTO A {@link GeneroPutRequestDTO} contendo os dados do genero
     * @param id O ID do genero a ser atualizado
     * @return Um ResponseEntity contendo o genero atualizado e o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
     * @see GeneroService#atualizarGenero(Integer, GeneroPutRequestDTO), GeneroPutRequestDTO, GeneroFullResponseDTO
     */
    @PutMapping
    public ResponseEntity<GeneroFullResponseDTO> atualizarGenero (@RequestBody @Valid GeneroPutRequestDTO generoPutRequestDTO, @RequestParam Integer id ) {
        try {
            GeneroFullResponseDTO generoFullResponseDTO = service.atualizarGenero( id, generoPutRequestDTO);
            return new ResponseEntity<>( generoFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Método GET para listar todos os generos
     * @return Um ResponseEntity contendo a lista de generos e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see GeneroService#listarGeneros(), GeneroFullResponseDTO
     */
    @GetMapping
    public ResponseEntity<List<GeneroFullResponseDTO>> listarGeneros () {
        try {
            return new ResponseEntity<>( service.listarGeneros(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Método GET para buscar um genero
     * @param id O ID do genero a ser buscado
     * @return Um ResponseEntity contendo o genero buscado e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see GeneroService#buscarGenero(Integer), GeneroFullResponseDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<GeneroFullResponseDTO> buscarGenero ( @PathVariable @Positive Integer id ) {
        try {
            GeneroFullResponseDTO generoFullResponseDTO = service.buscarGenero( id );
            return new ResponseEntity<>( generoFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Método DELETE para deletar um genero
     * @param id O ID do genero a ser deletado
     * @return Um ResponseEntity contendo o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
     * @see GeneroService#deletarGenero(Integer)
     */
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
