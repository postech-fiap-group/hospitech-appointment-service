package dev.call.appointment.exception;

import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioCamposInvalidosException extends RuntimeException {
    public UsuarioCamposInvalidosException(Set<String> violasoes) {
        super(String.join(" | ", violasoes));
    }
}