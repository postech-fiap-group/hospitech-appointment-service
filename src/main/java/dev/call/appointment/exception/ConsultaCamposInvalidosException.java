package dev.call.appointment.exception;

import java.util.Set;

public class ConsultaCamposInvalidosException extends RuntimeException {
    public ConsultaCamposInvalidosException(Set<String> violasoes) {
        super(String.join(" | ", violasoes));
    }
}