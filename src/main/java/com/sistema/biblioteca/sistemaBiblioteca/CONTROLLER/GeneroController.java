package com.sistema.biblioteca.sistemaBiblioteca.CONTROLLER;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO.GeneroPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.GENERO.GeneroRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.GENERO.GeneroFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.SERVICE.GeneroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    @Tag( name = "Genero", description = "Recurso para gerenciamento de generos" )
    @Operation( summary = "Criar um novo genero", description = "Endpoint para criar um novo genero" )
    @ApiResponse( responseCode = "201", description = "Genero criado com sucesso",
            content = @Content( schema = @Schema( implementation = GeneroFullResponseDTO.class ) , examples = @ExampleObject( value = "{ \"id\": 1, \"nome\": \"Romance\", \"descricao\": \"Livros de romance\" }" ) ))
    @ApiResponse( responseCode = "400", description = "Erro ao criar genero" )
    @ApiResponse( responseCode = "500", description = "Erro interno do servidor" )
    @SecurityRequirement( name = "Bearer" )
    @PostMapping
    public ResponseEntity<GeneroFullResponseDTO> criarGenero (
            @RequestBody @Parameter( description = "Dados do genero", required = true, example = "{ \"nome\": \"Romance\", \"descricao\": \"Livros de romance\" }", content = @Content( schema = @Schema( implementation = GeneroRequestDTO.class ) ) ) @Valid GeneroRequestDTO generoRequestDTO ) {
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
    @Tag( name = "Genero", description = "Recurso para gerenciamento de generos" )
    @Operation( summary = "Atualizar um genero", description = "Endpoint para atualizar um genero" )
    @ApiResponse( responseCode = "200", description = "Genero atualizado com sucesso",
        content = @Content( schema = @Schema( implementation = GeneroFullResponseDTO.class ) , examples = @ExampleObject( value = "{ \"id\": 1, \"nome\": \"Romance\", \"descricao\": \"Livros de romance\" }" ) ))
    @ApiResponse( responseCode = "400", description = "Erro ao atualizar genero" )
    @ApiResponse( responseCode = "500", description = "Erro interno do servidor" )
    @SecurityRequirement( name = "Bearer" )
    @PutMapping
    public ResponseEntity<GeneroFullResponseDTO> atualizarGenero (
            @RequestBody @Parameter ( description = "Dados do genero", required = true, example = "{ \"nome\": \"Romance\", \"descricao\": \"Livros de romance\" }", content = @Content( schema = @Schema( implementation = GeneroPutRequestDTO.class ) ) ) @Valid GeneroPutRequestDTO generoPutRequestDTO,
            @RequestParam @Parameter ( description = "ID do genero", required = true, example = "1") Integer id ) {
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
    @Tag( name = "Genero", description = "Recurso para gerenciamento de generos" )
    @Operation( summary = "Listar todos os generos", description = "Endpoint para listar todos os generos" )
    @ApiResponse( responseCode = "200", description = "Generos listados com sucesso",
        content = @Content( schema = @Schema( implementation = GeneroFullResponseDTO.class ) , examples = @ExampleObject( value = "{ \"id\": 1, \"nome\": \"Romance\", \"descricao\": \"Livros de romance\" }" ) ))
    @ApiResponse( responseCode = "404", description = "Nenhum genero encontrado" )
    @ApiResponse( responseCode = "500", description = "Erro interno do servidor" )
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
    @Tag( name = "Genero", description = "Recurso para gerenciamento de generos" )
    @Operation( summary = "Busca um genero pelo ID", description = "Busca um genero pelo ID e retorna o genero com o status HTTP 200" )
    @ApiResponse( responseCode = "200", description = "Genero encontrado com sucesso",
        content = @Content( schema = @Schema( implementation = GeneroFullResponseDTO.class ) , examples = @ExampleObject( value = "{ \"id\": 1, \"nome\": \"Romance\", \"descricao\": \"Livros de romance\" }" ) ))
    @ApiResponse( responseCode = "404", description = "Genero nao encontrado" )
    @ApiResponse( responseCode = "500", description = "Erro interno do servidor" )
    @GetMapping("/{id}")
    public ResponseEntity<GeneroFullResponseDTO> buscarGenero ( @PathVariable @Positive @NotNull @Parameter( description = "ID do genero", required = true, example = "1" ) Integer id ) {
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
    @Tag( name = "Genero", description = "Recurso para gerenciamento de generos" )
    @Operation( summary = "Deletar um genero", description = "Endpoint para deletar um genero" )
    @ApiResponse( responseCode = "200", description = "Genero deletado com sucesso" )
    @ApiResponse( responseCode = "400", description = "Erro ao deletar genero" )
    @ApiResponse( responseCode = "500", description = "Erro interno do servidor" )
    @SecurityRequirement( name = "Bearer" )
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
