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

    /**
     * Creates a new loan for a given user and book.
     *
     * @param emprestimoRequestDTO The {@link EmprestimoRequestDTO} containing the user and book IDs.
     * @return A {@link ResponseEntity} containing the created {@link EmprestimoFullResponseDTO} or a 400 status code if the input is invalid.
     * @see EmprestimoService#criarEmprestimo(EmprestimoRequestDTO)
     */
    @PostMapping
    public ResponseEntity<EmprestimoFullResponseDTO> criarEmprestimo ( EmprestimoRequestDTO emprestimoRequestDTO ) {

        try {
            return new ResponseEntity<>(service.criarEmprestimo(emprestimoRequestDTO), HttpStatus.CREATED);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Updates an existing loan with the provided data.
     *
     * @param emprestimoPutRequestDTO The {@link EmprestimoPutRequestDTO} containing the updated loan data.
     * @param id The ID of the loan to be updated.
     * @return A {@link ResponseEntity} containing the updated {@link EmprestimoFullResponseDTO} or a 400 status code if the update fails.
     * @see EmprestimoService#atualizarEmprestimo(EmprestimoPutRequestDTO, Integer)
     */
    @PutMapping
    public ResponseEntity<EmprestimoFullResponseDTO> atualizarEmprestimo ( EmprestimoPutRequestDTO emprestimoPutRequestDTO, @RequestParam Integer id ) {

        try {
            return new ResponseEntity<>(service.atualizarEmprestimo(emprestimoPutRequestDTO, id), HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Returns the loan with the given ID.
     *
     * @param id The ID of the loan to be returned.
     * @return A {@link ResponseEntity} containing the requested {@link EmprestimoFullResponseDTO} or a 400 status code if the loan is not found.
     * @see EmprestimoService#buscarEmprestimo(Integer)
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoFullResponseDTO> buscarEmprestimo ( @RequestParam Integer id ) {

        try {
            return new ResponseEntity<>(service.buscarEmprestimo(id), HttpStatus.OK);
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Returns a list of all existing loans.
     *
     * @return A {@link ResponseEntity} containing a list of {@link EmprestimoFullResponseDTO} objects or a 400 status code if the input is invalid.
     * @see EmprestimoService#listarEmprestimos()
     */
    @GetMapping
    public ResponseEntity<List<EmprestimoFullResponseDTO>> listarEmprestimos () {

        try {
            return new ResponseEntity<>(service.listarEmprestimos(), HttpStatus.OK);
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Marks the loan with the given ID as returned.
     *
     * @param id The ID of the loan to be marked as returned.
     * @return A {@link ResponseEntity} containing a 200 status code if the loan is found and successfully marked as returned, or a 400 status code if the loan is not found.
     * @see EmprestimoService#terminarEmprestimo(Integer)
     */
    @PatchMapping("/{id}")
    public ResponseEntity<EmprestimoFullResponseDTO> devolverLivro ( @PathVariable @Positive Integer id ) {

        try {
            service.terminarEmprestimo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deletes the loan with the given ID.
     *
     * @param id The ID of the loan to be deleted.
     * @return A {@link ResponseEntity} containing a 200 status code if the loan is found and successfully deleted, or a 400 status code if the loan is not found.
     * @see EmprestimoService#deletarEmprestimo(Integer)
     */
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
