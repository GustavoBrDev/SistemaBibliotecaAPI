package com.sistema.biblioteca.sistemaBiblioteca.SERVICE;

import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO.UsuarioPutRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.REQUEST.USUARIO.UsuarioRequestDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.DTO.RESPONSE.USUARIO.UsuarioFullResponseDTO;
import com.sistema.biblioteca.sistemaBiblioteca.MODELS.ENTITY.Usuario;
import com.sistema.biblioteca.sistemaBiblioteca.REPOSITORY.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioFullResponseDTO criarUsuario ( UsuarioRequestDTO usuarioRequestDTO ) {

        return repository.save( usuarioRequestDTO.converter() ).converterTudo();
    }

    public UsuarioFullResponseDTO atualizarUsuario (UsuarioPutRequestDTO usuarioPutRequestDTO, Integer id ) {

        if ( repository.existsById(id) ) {
            return repository.save( usuarioPutRequestDTO.converter() ).converterTudo();
        }

        throw new RuntimeException("Usuario não encontrado");
    }

    public UsuarioFullResponseDTO buscarUsuario ( Integer id ) {

        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    public List<UsuarioFullResponseDTO> listarUsuarios () {
        try {
            return repository.findAll().stream().map(Usuario::converterTudo).toList();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    public void deletarUsuario ( Integer id ) {

        if ( repository.existsById(id) ) {
            repository.deleteById(id);
        }

        throw new RuntimeException("Usuario não encontrado");
    }

}
