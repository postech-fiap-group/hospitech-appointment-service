package dev.call.appointment.service;

import dev.call.appointment.domain.usuario.Usuario;
import dev.call.appointment.domain.usuario.dto.UsuarioCreateDto;
import dev.call.appointment.domain.usuario.dto.UsuarioDetailsDto;
import dev.call.appointment.domain.usuario.dto.UsuarioLoginDto;
import dev.call.appointment.exception.UsuarioCamposInvalidosException;
import dev.call.appointment.infra.security.TokenService;
import dev.call.appointment.repository.UsuarioRepository;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final Validator validator;
    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public UsuarioService(UsuarioRepository repository, Validator validator, PasswordEncoder passwordEncoder, AuthenticationManager manager, TokenService tokenService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.validator = validator;
        this.manager = manager;
        this.tokenService = tokenService;
    }

    public List<UsuarioDetailsDto> getAll() {
        List<Usuario> usuarios = repository.findAll();
        return usuarios.stream().map(UsuarioDetailsDto::new).collect(Collectors.toList());
    }

    public UsuarioDetailsDto save(UsuarioCreateDto dto) {
        verificacaoDto(dto);

        String passEnconded = passwordEncoder.encode(dto.senha());
        Usuario newUsuario = new Usuario(dto, passEnconded);
        repository.save(newUsuario);

        return new UsuarioDetailsDto(newUsuario);
    }

    public String login(UsuarioLoginDto dto) {
        verificacaoDto(dto);

        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        var authentication = manager.authenticate(authenticationToken);

        return tokenService.gerarToken((Usuario) authentication.getPrincipal());
    }

    private void verificacaoDto(Object dto) {
        var erros = this.validator.validateObject(dto)
                .getAllErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toSet());

        if (!erros.isEmpty()) {
            throw new UsuarioCamposInvalidosException(erros);
        }
    }


}
