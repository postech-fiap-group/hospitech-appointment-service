package dev.call.appointment.domain.consulta.dto;

import dev.call.appointment.domain.consulta.Consulta;
import dev.call.appointment.domain.consulta.Especialidade;

public record ConsultaDto(
        Long id,
        Long pacienteId,
        Long medicoId,
        String dataHora,
        Especialidade especialidade,
        String observacoes) {

    public ConsultaDto(Consulta consulta) {
        this(consulta.getId(), consulta.getPacienteId().getId(),consulta.getMedicoId().getId(), consulta.getDataHoraConsulta().toString(), consulta.getEspecialidade(), consulta.getObservacoes());
    }
}
