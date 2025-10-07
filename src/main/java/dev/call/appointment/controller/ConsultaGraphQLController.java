package dev.call.appointment.controller;

import dev.call.appointment.domain.consulta.Consulta;
import dev.call.appointment.infra.graphql.ConsultaMapper;
import dev.call.appointment.infra.graphql.GraphQLConsultaDto;
import dev.call.appointment.repository.ConsultaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ConsultaGraphQLController {

    private final ConsultaRepository consultaRepository;

    public ConsultaGraphQLController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @QueryMapping
    public GraphQLConsultaDto consulta(@Argument Long id) {
        return consultaRepository.findById(id)
                .map(ConsultaMapper::toDTO)
                .orElse(null); // GraphQL retornará null se não achar
    }

    @QueryMapping
    public List<GraphQLConsultaDto> consultas(@Argument Long pacienteId,
                                              @Argument Boolean futuras) {
        boolean apenasFuturas = Boolean.TRUE.equals(futuras);
        LocalDateTime agora = LocalDateTime.now();

        List<Consulta> resultados;

        if (pacienteId != null && apenasFuturas) {
            resultados = consultaRepository
                    .findByPacienteId_IdAndDataHoraConsultaAfter(pacienteId, agora);
        } else if (pacienteId != null) {
            resultados = consultaRepository.findByPacienteId_Id(pacienteId);
        } else if (apenasFuturas) {
            resultados = consultaRepository.findByDataHoraConsultaAfter(agora);
        } else {
            resultados = consultaRepository.findAll();
        }

        return resultados.stream().map(ConsultaMapper::toDTO).toList();
    }
}

