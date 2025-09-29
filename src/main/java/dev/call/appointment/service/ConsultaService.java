package dev.call.appointment.service;

import dev.call.appointment.domain.consulta.dto.ConsultaCreateDto;
import dev.call.appointment.domain.consulta.dto.ConsultaDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    public List<ConsultaDto> getAll() {
        return List.of();
    }

    public ConsultaDto save(@Valid ConsultaCreateDto dto) {
        return null;
    }

    public ConsultaDto getById(Integer id) {
        return null;
    }

    public ConsultaDto update(@Valid ConsultaCreateDto dto) {
        return null;
    }
}
