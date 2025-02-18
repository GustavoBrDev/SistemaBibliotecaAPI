package com.sistema.biblioteca.sistemaBiblioteca.CONTROLLER;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO.UsuarioPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO.UsuarioRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO.UsuarioFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.SERVICE.UsuarioService;
import jakarta.validation.Valid;
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
    @PostMapping
    public ResponseEntity<UsuarioFullResponseDTO> criarUsuario ( @RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO ) {

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
    @PutMapping
    public ResponseEntity<UsuarioFullResponseDTO> atualizarUsuario ( @RequestBody @Valid UsuarioPutRequestDTO usuarioPutRequestDTO, @RequestParam Integer id ) {

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
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioFullResponseDTO> buscarUsuario ( @PathVariable @Positive Integer id ) {

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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario ( @PathVariable @Positive Integer id ) {

        try {
            service.deletarUsuario( id );
            return new ResponseEntity<>( HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
