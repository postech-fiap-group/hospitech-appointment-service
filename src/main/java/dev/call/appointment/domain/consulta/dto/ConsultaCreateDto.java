package dev.call.appointment.domain.consulta.dto;

import dev.call.appointment.domain.consulta.Especialidade;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record ConsultaCreateDto(
        @NotNull(message = "O Campo id do paciente é obrigatório")
        @Positive(message = "O id do paciente deve ser um número positivo")
        Long pacienteId,

        @NotNull(message = "O Campo id do médico é obrigatório")
        @Positive(message = "O id do médico deve ser um número positivo")
        Long medicoId,

        @NotNull(message = "O Campo data e hora da consulta é obrigatório")
        LocalDateTime dataHora,

        @NotNull(message = "O Campo especialidade é obrigatório")
        Especialidade especialidade,

        String observacoes) {
}
