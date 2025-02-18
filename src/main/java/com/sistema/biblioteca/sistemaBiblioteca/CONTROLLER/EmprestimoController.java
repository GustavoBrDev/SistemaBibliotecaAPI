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

/**
 * Classe de controle para os emprestimos
 * @see EmprestimoService, Emprestimo
 * @version 1.0
 * @since 2025
 * @author Gustavo Stinghen
 */
@RestController
@AllArgsConstructor
@RequestMapping("/emprestimos")
public class EmprestimoController {

    /**
     * O serviço de emprestimos que permite criar, atualizar, buscar, listar e deletar emprestimos
     * @see EmprestimoService
     */
    private EmprestimoService service;

    /**
     * Método POST para criar um novo emprestimo
     * @param emprestimoRequestDTO A {@link EmprestimoRequestDTO} contendo os dados do emprestimo
     * @return Um ResponseEntity contendo o empréstimo criado e o status HTTP 201 (Created) ou o status HTTP 400 (Bad Request).
     * @see EmprestimoService#criarEmprestimo(EmprestimoRequestDTO), EmprestimoRequestDTO
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
     * Método PUT para atualizar um emprestimo existente
     * @param emprestimoPutRequestDTO A {@link EmprestimoPutRequestDTO} contendo os dados do emprestimo
     * @param id O ID do emprestimo a ser atualizado
     * @return Um ResponseEntity contendo o empréstimo atualizado e o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
     * @see EmprestimoService#atualizarEmprestimo(EmprestimoPutRequestDTO, Integer), EmprestimoPutRequestDTO, EmprestimoFullResponseDTO
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
     * Método GET para buscar um emprestimo existente
     * @param id O ID do emprestimo a ser buscado
     * @return Um ResponseEntity contendo o empréstimo buscado e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see EmprestimoService#buscarEmprestimo(Integer), EmprestimoFullResponseDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoFullResponseDTO> buscarEmprestimo ( @RequestParam Integer id ) {

        try {
            return new ResponseEntity<>(service.buscarEmprestimo(id), HttpStatus.OK);
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método GET para listar todos os emprestimos
     * @return Um ResponseEntity contendo a lista de emprestimos e o status HTTP 200 (OK) ou o status HTTP 404 (Not Found).
     * @see EmprestimoService#listarEmprestimos(), EmprestimoFullResponseDTO
     */
    @GetMapping
    public ResponseEntity<List<EmprestimoFullResponseDTO>> listarEmprestimos () {

        try {
            return new ResponseEntity<>(service.listarEmprestimos(), HttpStatus.OK);
        } catch ( RuntimeException e ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método PATCH para devolver um emprestimo
     * @param id O ID do emprestimo a ser devolvido
     * @return Um ResponseEntity contendo o emprestimo devolvido e o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
     * @see EmprestimoService#terminarEmprestimo(Integer), EmprestimoFullResponseDTO
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
     * Método DELETE para deletar um emprestimo
     * @param id O ID do emprestimo a ser deletado
     * @return Um ResponseEntity contendo o status HTTP 200 (OK) ou o status HTTP 400 (Bad Request).
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
