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

    /**
     * Creates a new user and returns it with status 201 (Created).
     *
     * @param usuarioRequestDTO The user to be created.
     * @return The created user.
     */
    public UsuarioFullResponseDTO criarUsuario ( UsuarioRequestDTO usuarioRequestDTO ) {

        return repository.save( usuarioRequestDTO.converter() ).converterTudo();
    }

    /**
     * Updates an existing user and returns the updated user.
     *
     * @param usuarioPutRequestDTO The updated user data.
     * @param id The ID of the user to be updated.
     * @return A ResponseEntity containing the updated user and an HTTP status code.
     * Returns HttpStatus.OK if the operation is successful, otherwise returns HttpStatus.BAD_REQUEST.
     */
    public UsuarioFullResponseDTO atualizarUsuario (UsuarioPutRequestDTO usuarioPutRequestDTO, Integer id ) {

        if ( repository.existsById(id) ) {
            return repository.save( usuarioPutRequestDTO.converter() ).converterTudo();
        }

        throw new RuntimeException("Usuario não encontrado");
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to be retrieved.
     * @return The retrieved user.
     * @throws RuntimeException if the user does not exist.
     */
    public UsuarioFullResponseDTO buscarUsuario ( Integer id ) {

        try {
            return repository.findById( id ).get().converterTudo();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list of {@link UsuarioFullResponseDTO}.
     * @throws RuntimeException if no users are found.
     */
    public List<UsuarioFullResponseDTO> listarUsuarios () {
        try {
            return repository.findAll().stream().map(Usuario::converterTudo).toList();
        } catch ( RuntimeException e ) {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    /**
     * Deletes a user by their ID.
     * @param id The ID of the user to be deleted.
     * @throws RuntimeException if the user does not exist.
     */
    public void deletarUsuario ( Integer id ) {

        if ( repository.existsById(id) ) {
            repository.deleteById(id);
        }

        throw new RuntimeException("Usuario não encontrado");
    }

}
