package dev.call.appointment.domain.usuario;

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
