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

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService service;

    /**
     * Creates a new user and returns it with status 201 (Created).
     *
     * @param usuarioRequestDTO The user to be created.
     * @return The created user.
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
     * Updates an existing user and returns the updated user.
     *
     * @param usuarioPutRequestDTO The updated user data.
     * @param id The ID of the user to be updated.
     * @return A ResponseEntity containing the updated user and an HTTP status code.
     * Returns HttpStatus.OK if the operation is successful, otherwise returns HttpStatus.BAD_REQUEST.
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
     * Retrieves a list of all users.
     *
     * @return A ResponseEntity containing a list of {@link UsuarioFullResponseDTO} and an HTTP status code.
     * Returns HttpStatus.OK if the operation is successful, otherwise returns HttpStatus.BAD_REQUEST.
     */
    @GetMapping
    public ResponseEntity<List<UsuarioFullResponseDTO>> listarUsuarios () {

        try {
            return new ResponseEntity<>( service.listarUsuarios(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to be retrieved.
     * @return A ResponseEntity containing the retrieved user and an HTTP status code.
     * Returns HttpStatus.OK if the operation is successful, otherwise returns HttpStatus.BAD_REQUEST.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioFullResponseDTO> buscarUsuario ( @PathVariable @Positive Integer id ) {

        try {
            UsuarioFullResponseDTO usuarioFullResponseDTO = service.buscarUsuario( id );
            return new ResponseEntity<>( usuarioFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Deletes a user by their ID.
     * @param id The ID of the user to be deleted.
     * @return A ResponseEntity containing an HTTP status code.
     * Returns HttpStatus.OK if the operation is successful, otherwise returns HttpStatus.BAD_REQUEST.
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
