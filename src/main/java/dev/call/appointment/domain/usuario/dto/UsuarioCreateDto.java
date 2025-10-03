package dev.call.appointment.domain.usuario.dto;

import dev.call.appointment.domain.usuario.TipoUsuario;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCreateDto (
        @NotBlank(message = "O campo nome é obrigatório")
        String nome,
        @NotBlank(message = "0 campo email é obrigatório")
        String email,
        @NotBlank(message = "O Campo senha é obrigatório")
        String senha,
        TipoUsuario tipoUsuario
) {
}
