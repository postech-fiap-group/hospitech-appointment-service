package dev.call.appointment.repository;

import dev.call.appointment.domain.usuario.TipoUsuario;
import dev.call.appointment.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    boolean existsByIdAndTipo(Long id, TipoUsuario tipo);
}
