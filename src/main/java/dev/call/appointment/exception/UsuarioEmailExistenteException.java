package dev.call.appointment.exception;

public class UsuarioEmailExistenteException extends RuntimeException{
    public UsuarioEmailExistenteException() {
        super("Email já cadastrado!");
    }
}
