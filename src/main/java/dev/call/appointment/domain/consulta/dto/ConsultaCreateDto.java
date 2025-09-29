package dev.call.appointment.domain.consulta.dto;

public record ConsultaCreateDto(
        Long pacienteId,
        Long medicoId,
        String dataHora,
        String especialidade) {
}
