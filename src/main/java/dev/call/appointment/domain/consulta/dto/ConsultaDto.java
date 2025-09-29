package dev.call.appointment.domain.consulta.dto;

public record ConsultaDto(
        Long id,
        Long pacienteId,
        Long medicoId,
        String dataHora,
        String especialidade) {
}
