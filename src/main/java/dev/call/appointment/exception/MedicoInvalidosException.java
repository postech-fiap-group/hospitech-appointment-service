package dev.call.appointment.exception;

public class MedicoInvalidosException extends RuntimeException {
    public MedicoInvalidosException() {
        super("Médico não encontrado ou inválido.");
    }
}