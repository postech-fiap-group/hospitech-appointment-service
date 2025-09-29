package dev.call.appointment.domain.usuario.dto;

import dev.call.appointment.domain.usuario.TipoUsuario;
import dev.call.appointment.domain.usuario.Usuario;

public record UsuarioDetailsDto(
        Long id,
        String email,
        String nome,
        TipoUsuario tipo
) {
    public UsuarioDetailsDto(Usuario usuario) {
        this(usuario.getId(), usuario.getEmail(), usuario.getNome(), usuario.getTipo());
    }
}
