package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO.EmprestimoPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO.EmprestimoRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO.EmprestimoFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Emprestimo;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmprestimoService {

    private EmprestimoRepository repository;
    private LivroService livroService;

    /**
     * Creates a new loan for a given user and book.
     *
     * @param emprestimoRequestDTO The {@link EmprestimoRequestDTO} containing the user and book IDs.
     * @return A {@link EmprestimoFullResponseDTO} containing the created loan data.
     */
    public EmprestimoFullResponseDTO criarEmprestimo ( EmprestimoRequestDTO emprestimoRequestDTO ) {

        Emprestimo emprestimo = emprestimoRequestDTO.converter();

        if ( emprestimo.getDevolvido() ) {
            livroService.emprestarLivro( emprestimo.getLivro().getId() );
        } else {
            livroService.devolverLivro( emprestimo.getLivro().getId() );
        }

        return repository.save( emprestimo ).converterTudo();
    }

    /**
     * Updates an existing loan with the provided data.
     *
     * @param emprestimoPutRequestDTO The {@link EmprestimoPutRequestDTO} containing the updated loan data.
     * @param id The ID of the loan to be updated.
     * @return A {@link EmprestimoFullResponseDTO} containing the updated loan data.
     * @throws RuntimeException If the loan is not found.
     */
    public EmprestimoFullResponseDTO atualizarEmprestimo (EmprestimoPutRequestDTO emprestimoPutRequestDTO, Integer id ) {

        try {
            Emprestimo emprestimo = emprestimoPutRequestDTO.converter();
            emprestimo.setId(id);

            if ( emprestimo.getDevolvido() ) {
                livroService.emprestarLivro( emprestimo.getLivro().getId() );
            } else {
                livroService.devolverLivro( emprestimo.getLivro().getId() );
            }

            return repository.save( emprestimo ).converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }

    /**
     * Returns the loan with the given ID.
     *
     * @param id The ID of the loan to be returned.
     * @return A {@link EmprestimoFullResponseDTO} containing the loan data.
     * @throws RuntimeException If the loan is not found.
     */
    public EmprestimoFullResponseDTO buscarEmprestimo ( Integer id ) {
        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }

    /**
     * Returns a list of all existing loans.
     *
     * @return A list of {@link EmprestimoFullResponseDTO} objects containing the loan data.
     * @throws RuntimeException If there are no loans.
     */
    public List<EmprestimoFullResponseDTO> listarEmprestimos () {
        try {
            return repository.findAll().stream().map(Emprestimo::converterTudo).toList();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }

    /**
     * Marks the loan with the given ID as returned.
     *
     * @param id The ID of the loan to be marked as returned.
     * @return A {@link EmprestimoFullResponseDTO} containing the updated loan data.
     * @throws RuntimeException If the loan is not found.
     */
    public EmprestimoFullResponseDTO terminarEmprestimo ( Integer id ) {
        try {
            Emprestimo emprestimo = repository.findById( id ).get();
            emprestimo.setDevolvido( true );
            livroService.devolverLivro( emprestimo.getLivro().getId() );
            repository.save( emprestimo );
            return emprestimo.converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }

    /**
     * Deletes the loan with the given ID.
     *
     * @param id The ID of the loan to be deleted.
     * @throws RuntimeException If the loan is not found.
     */
    public void deletarEmprestimo ( Integer id ) {
        try {
            repository.deleteById(id);
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }
}
