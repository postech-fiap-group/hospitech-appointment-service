package dev.call.appointment.repository;

import dev.call.appointment.domain.consulta.Consulta;
import dev.call.appointment.domain.usuario.TipoUsuario;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConsultaUsuariosValidator implements ConstraintValidator<ConsultaUsuariosValidos, Consulta> {

    private final UsuarioRepository usuarioRepository;

    public ConsultaUsuariosValidator(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public boolean isValid(Consulta consulta, ConstraintValidatorContext constraintValidatorContext) {
        if (consulta.getMedicoId() == null || consulta.getPacienteId() == null) {
            return false;
        }

        boolean medicoValido = usuarioRepository.existsByIdAndTipo(consulta.getMedicoId().getId(), TipoUsuario.MEDICO);
        boolean pacienteValido = usuarioRepository.existsByIdAndTipo(consulta.getPacienteId().getId(), TipoUsuario.PACIENTE);
        return medicoValido && pacienteValido;

    }
}
