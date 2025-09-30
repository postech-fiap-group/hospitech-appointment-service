package dev.call.appointment.domain.consulta.dto;

import dev.call.appointment.domain.consulta.Especialidade;
import jakarta.validation.constraints.NotBlank;

public record ConsultaCreateDto(
        @NotBlank(message = "O Campo id do paciente é obrigatório")
        Long pacienteId,
        @NotBlank(message = "O Campo id do médico é obrigatório")
        Long medicoId,
        @NotBlank(message = "O Campo data e hora da consulta é obrigatório")
        String dataHora,
        @NotBlank(message = "O Campo especialidade é obrigatório")
        String especialidade,
        String observacoes) {
}
