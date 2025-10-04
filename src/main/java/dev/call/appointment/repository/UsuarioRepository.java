package dev.call.appointment.repository;

import dev.call.appointment.domain.usuario.TipoUsuario;
import dev.call.appointment.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    Optional<Usuario> findByIdAndTipo(Long id, TipoUsuario tipo);
}
