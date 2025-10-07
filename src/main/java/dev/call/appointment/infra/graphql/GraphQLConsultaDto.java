package dev.call.appointment.infra.graphql;

import dev.call.appointment.domain.consulta.Especialidade;
import java.time.OffsetDateTime;

public record GraphQLConsultaDto(
        Long id,
        Long pacienteId,
        Long medicoId,
        Especialidade especialidade,
        OffsetDateTime dataHoraConsulta,
        String observacoes
) {}
