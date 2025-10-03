package dev.call.appointment.commands;

import java.time.LocalDate;

public record NotificarCommand(String pacienteNome,
		String pacienteEmail,
		String especialidadeConsulta,
		LocalDate dataConsulta,
		String medicoNome) {
}