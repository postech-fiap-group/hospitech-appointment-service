package dev.call.appointment.domain.consulta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ConsultaCreateDto(
        @NotNull(message = "O Campo id do paciente é obrigatório")
        @Positive(message = "O id do paciente deve ser um número positivo")
        Long pacienteId,

        @NotNull(message = "O Campo id do médico é obrigatório")
        @Positive(message = "O id do médico deve ser um número positivo")
        Long medicoId,

        @NotBlank(message = "O Campo data e hora da consulta é obrigatório")
        String dataHora,
        @NotBlank(message = "O Campo especialidade é obrigatório")
        String especialidade,
        String observacoes) {
}
