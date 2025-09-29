package dev.call.appointment.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioLoginDto(
        @NotBlank(message = "O campo email é obrigatório")
        String email,
        @NotBlank(message = "O campo senha é obrigatório")
        String senha) {
}
