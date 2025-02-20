package com.sistema.biblioteca.sistemaBiblioteca.CONTROLLER;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO.UsuarioPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO.UsuarioRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO.UsuarioFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.SERVICE.UsuarioService;
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
 * Classe de contole para o recurso de usuarios.
 * @see UsuarioService, Usuario
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    /**
     * Serviço de usuarios que permite criar, atualizar, buscar, listar e deletar usuarios
     * @see UsuarioService
     */
    private UsuarioService service;

    /**
     * Método POST para criar um novo usuario
     * @param usuarioRequestDTO A {@link UsuarioRequestDTO} contendo os dados do usuario
     * @return Um ResponseEntity contendo o usuario criado e o status HTTP 201 (Created) ou o status HTTP 400 (Bad Request).
     * @see UsuarioService#criarUsuario(UsuarioRequestDTO), UsuarioRequestDTO, UsuarioFullResponseDTO
     */
    @Tag( name = "Usuario", description = "Recurso para gerenciamento de usuarios" )
    @Operation( summary = "Criar um usuario", description = "Endpoint para criar um usuario" )
    @ApiResponse ( responseCode = "201", description = "Usuario criado com sucesso", content = @Content ( schema = @Schema( implementation = UsuarioFullResponseDTO.class ),
            examples = @ExampleObject( value = "{ \"id\": 1, \"nome\": \"Gustavo Stinghen\", \"email\": \"tX2Xu@example.com\", \"senha\": \"12345678\" }" ) ) )
    @ApiResponse( responseCode = "400", description = "Erro ao criar usuario" )
    @ApiResponse( responseCode = "500", description = "Erro interno do servidor" )
    @SecurityRequirement( name = "Bearer" )
    @PostMapping
    public ResponseEntity<UsuarioFullResponseDTO> criarUsuario (
            @RequestBody @Parameter ( required = true, example = "{ \"nome\": \"Gustavo Stinghen\", \"email\": \"tX2Xu@example.com\", \"senha\": \"12345678\" }", content = @Content ( schema = @Schema ( implementation = UsuarioRequestDTO.class ) ) , description = "Usuario a ser criado" ) @Valid UsuarioRequestDTO usuarioRequestDTO ) {

        try {
            UsuarioFullResponseDTO usuarioFullResponseDTO = service.criarUsuario( usuarioRequestDTO );
            return new ResponseEntity<>( usuarioFullResponseDTO, HttpStatus.CREATED );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Método de PUT para atualizar um usuario
     * @param usuarioPutRequestDTO A {@link UsuarioPutRequestDTO} contendo os dados do usuario
     * @param id O ID do usuario a ser atualizado
     * @return Um ResponseEntity contendo o usuario atualizado e o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
     * @see UsuarioService#atualizarUsuario(UsuarioPutRequestDTO, Integer), UsuarioPutRequestDTO, UsuarioFullResponseDTO
     */
    @Tag( name = "Usuario", description = "Recurso para gerenciamento de usuarios" )
    @Operation( summary = "Atualizar um usuario", description = "Endpoint para atualizar um usuario" )
    @ApiResponse ( responseCode = "200", description = "Usuario atualizado com sucesso", content = @Content ( schema = @Schema( implementation = UsuarioFullResponseDTO.class ),
            examples = @ExampleObject( value = "{ \"id\": 1, \"nome\": \"Gustavo Stinghen\", \"email\": \"tX2Xu@example.com\", \"senha\": \"12345678\" }" ) ) )
    @ApiResponse( responseCode = "400", description = "Erro ao atualizar usuario" )
    @ApiResponse( responseCode = "500", description = "Erro interno do servidor" )
    @SecurityRequirement( name = "Bearer" )
    @PutMapping
    public ResponseEntity<UsuarioFullResponseDTO> atualizarUsuario (
            @RequestBody @Parameter ( required = true, description = "Usuario a ser atualizado", example = "{ \"nome\": \"Gustavo Stinghen\", \"email\": \"tX2Xu@example.com\", \"senha\": \"12345678\" }", content = @Content ( schema = @Schema ( implementation = UsuarioPutRequestDTO.class ) ) ) @Valid UsuarioPutRequestDTO usuarioPutRequestDTO,
            @RequestParam @Parameter ( required = true, example = "1", description = "ID do usuario a ser atualizado" ) Integer id ) {

        try {
            UsuarioFullResponseDTO usuarioFullResponseDTO = service.atualizarUsuario( usuarioPutRequestDTO, id );
            return new ResponseEntity<>( usuarioFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Metodo GET para listar todos os usuarios existentes
     * @return Um ResponseEntity contendo a lista de usuarios e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see UsuarioService#listarUsuarios(), UsuarioFullResponseDTO
     */
    @Tag( name = "Usuario", description = "Recurso para gerenciamento de usuarios" )
    @Operation( summary = "Listar todos os usuarios", description = "Endpoint para listar todos os usuarios" )
    @ApiResponse ( responseCode = "200", description = "Usuarios listados com sucesso", content = @Content ( schema = @Schema( implementation = UsuarioFullResponseDTO.class ),
            examples = @ExampleObject( value = "{ \"id\": 1, \"nome\": \"Gustavo Stinghen\", \"email\": \"tX2Xu@example.com\", \"senha\": \"12345678\" }" ) ) )
    @ApiResponse( responseCode = "404", description = "Nenhum usuario encontrado" )
    @ApiResponse( responseCode = "500", description = "Erro interno do servidor" )
    @GetMapping
    public ResponseEntity<List<UsuarioFullResponseDTO>> listarUsuarios () {

        try {
            return new ResponseEntity<>( service.listarUsuarios(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Metodo GET para buscar um usuario existente
     * @param id O ID do usuario a ser buscado
     * @return Um ResponseEntity contendo o usuario buscado e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see UsuarioService#buscarUsuario(Integer), UsuarioFullResponseDTO
     */
    @Tag( name = "Usuario", description = "Recurso para gerenciamento de usuarios" )
    @Operation( summary = "Busca um usuario pelo ID", description = "Busca um usuario pelo ID e retorna o usuario com o status HTTP 200" )
    @ApiResponse( responseCode = "200", description = "Usuario encontrado com sucesso", content = @Content ( schema = @Schema( implementation = UsuarioFullResponseDTO.class ),
            examples = @ExampleObject( value = "{ \"id\": 1, \"nome\": \"Gustavo Stinghen\", \"email\": \"tX2Xu@example.com\", \"senha\": \"12345678\" }" ) ) )
    @ApiResponse( responseCode = "404", description = "Usuario nao encontrado" )
    @ApiResponse( responseCode = "500", description = "Erro interno do servidor" )
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioFullResponseDTO> buscarUsuario (
            @PathVariable @Parameter ( required = true, example = "1", description = "ID do usuario a ser buscado" ) @NotNull @Positive Integer id ) {

        try {
            UsuarioFullResponseDTO usuarioFullResponseDTO = service.buscarUsuario( id );
            return new ResponseEntity<>( usuarioFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    /**
     * Metodo DELETE para deletar um usuario
     * @param id O ID do usuario a ser deletado
     * @return Um ResponseEntity contendo o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
     * @see UsuarioService#deletarUsuario(Integer)
     */
    @Tag( name = "Usuario", description = "Recurso para gerenciamento de usuarios" )
    @Operation( summary = "Deleta um usuario pelo ID", description = "Deleta um usuario pelo ID e retorna o status HTTP 200" )
    @ApiResponse( responseCode = "200", description = "Usuario deletado com sucesso" )
    @ApiResponse( responseCode = "400", description = "Nao foi possivel deletar o usuario" )
    @ApiResponse( responseCode = "500", description = "Erro interno do servidor" )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario ( @PathVariable @Parameter ( required = true, example = "1", description = "ID do usuario a ser deletado" ) @NotNull @Positive Integer id ) {

        try {
            service.deletarUsuario( id );
            return new ResponseEntity<>( HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
