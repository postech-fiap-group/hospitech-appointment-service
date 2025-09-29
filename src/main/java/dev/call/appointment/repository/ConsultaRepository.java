package dev.call.appointment.repository;

import dev.call.appointment.domain.consulta.Consulta;
import dev.call.appointment.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
