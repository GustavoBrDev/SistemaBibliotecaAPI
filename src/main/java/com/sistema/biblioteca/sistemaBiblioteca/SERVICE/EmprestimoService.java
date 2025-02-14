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

    public EmprestimoFullResponseDTO criarEmprestimo ( EmprestimoRequestDTO emprestimoRequestDTO ) {

        Emprestimo emprestimo = emprestimoRequestDTO.converter();

        if ( emprestimo.getDevolvido() ) {
            livroService.emprestarLivro( emprestimo.getLivro().getId() );
        } else {
            livroService.devolverLivro( emprestimo.getLivro().getId() );
        }

        return repository.save( emprestimo ).converterTudo();
    }

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

    public EmprestimoFullResponseDTO buscarEmprestimo ( Integer id ) {
        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }

    public List<EmprestimoFullResponseDTO> listarEmprestimos () {
        try {
            return repository.findAll().stream().map(Emprestimo::converterTudo).toList();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }

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

    public void deletarEmprestimo ( Integer id ) {
        try {
            repository.deleteById(id);
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Emprestimo não encontrado");
        }
    }
}
