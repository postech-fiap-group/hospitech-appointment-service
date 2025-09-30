package dev.call.appointment.exception;

public class ConsultaNotFoundException extends RuntimeException {
    public ConsultaNotFoundException() {
        super("Consulta não encontrado ou inválido.");
    }
}