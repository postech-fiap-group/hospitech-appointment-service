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
    public List<GraphQLConsultaDto> consultas() {
        return consultaRepository.findAll()
                .stream()
                .map(ConsultaMapper::toDTO)
                .toList();
    }
}

