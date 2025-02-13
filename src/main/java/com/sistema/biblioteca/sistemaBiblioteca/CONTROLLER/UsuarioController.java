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

    @PostMapping
    public ResponseEntity<UsuarioFullResponseDTO> criarUsuario ( @RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO ) {

        try {
            UsuarioFullResponseDTO usuarioFullResponseDTO = service.criarUsuario( usuarioRequestDTO );
            return new ResponseEntity<>( usuarioFullResponseDTO, HttpStatus.CREATED );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping
    public ResponseEntity<UsuarioFullResponseDTO> atualizarUsuario ( @RequestBody @Valid UsuarioPutRequestDTO usuarioPutRequestDTO, @RequestParam Integer id ) {

        try {
            UsuarioFullResponseDTO usuarioFullResponseDTO = service.atualizarUsuario( usuarioPutRequestDTO, id );
            return new ResponseEntity<>( usuarioFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<List<UsuarioFullResponseDTO>> listarUsuarios () {

        try {
            return new ResponseEntity<>( service.listarUsuarios(), HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioFullResponseDTO> buscarUsuario ( @PathVariable @Positive Integer id ) {

        try {
            UsuarioFullResponseDTO usuarioFullResponseDTO = service.buscarUsuario( id );
            return new ResponseEntity<>( usuarioFullResponseDTO, HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

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
