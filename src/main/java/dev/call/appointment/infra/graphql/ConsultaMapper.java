package dev.call.appointment.infra.graphql;

import dev.call.appointment.domain.consulta.Consulta;
import java.time.ZoneOffset;

public class ConsultaMapper {

    public static GraphQLConsultaDto toDTO(Consulta consulta) {
        return new GraphQLConsultaDto(
                consulta.getId(),
                consulta.getPacienteId().getId(),
                consulta.getMedicoId().getId(),
                consulta.getEspecialidade(),
                consulta.getDataHoraConsulta().atOffset(ZoneOffset.UTC),
                consulta.getObservacoes()
        );
    }
}
