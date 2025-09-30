package dev.call.appointment.exception;

import java.util.Set;

public class PacienteInvalidosException extends RuntimeException {
    public PacienteInvalidosException() {
        super("Paciente não encontrado ou inválido.");
    }
}