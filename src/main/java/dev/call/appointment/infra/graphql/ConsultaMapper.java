package dev.call.appointment.infra.graphql;

import dev.call.appointment.domain.consulta.Consulta;

public class ConsultaMapper {
    public static GraphQLConsultaDto toDTO(Consulta c) {
        return new GraphQLConsultaDto(
                c.getId(),
                c.getPacienteId() != null ? c.getPacienteId().getId() : null,
                c.getMedicoId() != null ? c.getMedicoId().getId() : null,
                c.getEspecialidade(),
                c.getDataHoraConsulta(),
                c.getObservacoes()
        );
    }
}

