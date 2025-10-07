package dev.call.appointment.infra.graphql;

import dev.call.appointment.domain.consulta.Especialidade;
import java.time.LocalDateTime;

public record GraphQLConsultaDto(
            Long id,
            Long pacienteId,
            Long medicoId,
            Especialidade especialidade,
            LocalDateTime dataHoraConsulta,
            String observacoes
) {}

