package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO.EmprestimoPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.EMPRESTIMO.EmprestimoRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.EMPRESTIMO.EmprestimoFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Emprestimo;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço para o recurso de emprestimos.
 * @see EmprestimoRepository, Emprestimo, LivroService
 * @author Gustavo Stinghen
 * @version 1.0
 * @since 2025
 */
@Service
@AllArgsConstructor
public class EmprestimoService {

    /**
     * Repository para o recurso de emprestimos.
     * @see EmprestimoRepository
     */
    private EmprestimoRepository repository;

    /**
     * Serviço de livros que permite criar, atualizar, buscar, listar e deletar livros
     * @see LivroService
     */
    private LivroService livroService;

    /**
     * Método para criar um novo emprestimo
     * @param emprestimoRequestDTO A {@link EmprestimoRequestDTO} contendo os dados do emprestimo
     * @return O emprestimo criado em forma de {@link EmprestimoFullResponseDTO}
     * @see EmprestimoRequestDTO, EmprestimoFullResponseDTO
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
     * Método para atualizar um emprestimo
     * @param emprestimoPutRequestDTO A {@link EmprestimoPutRequestDTO} contendo os dados do emprestimo
     * @param id O ID do emprestimo a ser atualizado
     * @return O emprestimo atualizado em forma de {@link EmprestimoFullResponseDTO}
     * @see EmprestimoPutRequestDTO, EmprestimoFullResponseDTO
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
     * Método para buscar um emprestimo
     * @param id O ID do emprestimo a ser buscado
     * @return O emprestimo buscado em forma de {@link EmprestimoFullResponseDTO}
     * @see EmprestimoFullResponseDTO
     */
    public EmprestimoFullResponseDTO buscarEmprestimo ( Integer id ) {
        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }

    /**
     * Método para listar todos os emprestimos
     * @return A lista de emprestimos em forma de {@link EmprestimoFullResponseDTO}
     * @see EmprestimoFullResponseDTO
     */
    public List<EmprestimoFullResponseDTO> listarEmprestimos () {
        try {
            return repository.findAll().stream().map(Emprestimo::converterTudo).toList();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }

    /**
     * Método para devolver um emprestimo
     * @param id O ID do emprestimo a ser devolvido
     * @return O emprestimo devolvido em forma de {@link EmprestimoFullResponseDTO}
     * @see EmprestimoFullResponseDTO, LivroService
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
     * Método para deletar um emprestimo
     * @param id O ID do emprestimo a ser deletado
     */
    public void deletarEmprestimo ( Integer id ) {
        try {
            repository.deleteById(id);
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }
}
