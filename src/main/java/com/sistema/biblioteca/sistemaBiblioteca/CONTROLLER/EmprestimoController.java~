package com.sistema.biblioteca.sistemaBiblioteca.CONTROLLER;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO.EmprestimoPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO.EmprestimoRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO.EmprestimoFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.SERVICE.EmprestimoService;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private EmprestimoService service;

    @PostMapping
    public ResponseEntity<EmprestimoFullResponseDTO> criarEmprestimo ( EmprestimoRequestDTO emprestimoRequestDTO ) {

        try {
            return new ResponseEntity<>(service.criarEmprestimo(emprestimoRequestDTO), HttpStatus.CREATED);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<EmprestimoFullResponseDTO> atualizarEmprestimo ( EmprestimoPutRequestDTO emprestimoPutRequestDTO, @RequestParam Integer id ) {

        try {
            return new ResponseEntity<>(service.atualizarEmprestimo(emprestimoPutRequestDTO, id), HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoFullResponseDTO> buscarEmprestimo ( @RequestParam Integer id ) {

        try {
            return new ResponseEntity<>(service.buscarEmprestimo(id), HttpStatus.OK);
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmprestimoFullResponseDTO>> listarEmprestimos () {

        try {
            return new ResponseEntity<>(service.listarEmprestimos(), HttpStatus.OK);
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmprestimoFullResponseDTO> devolverLivro ( @PathVariable @Positive Integer id ) {

        try {
            service.terminarEmprestimo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmprestimo ( @PathVariable @Positive Integer id ) {

        try {
            service.deletarEmprestimo( id );
            return new ResponseEntity<>( HttpStatus.OK );
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }


}
