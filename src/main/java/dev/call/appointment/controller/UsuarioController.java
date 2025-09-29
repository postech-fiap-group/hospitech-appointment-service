package dev.call.appointment.controller;

import dev.call.appointment.domain.usuario.dto.UsuarioCreateDto;
import dev.call.appointment.domain.usuario.dto.UsuarioDetailsDto;
import dev.call.appointment.domain.usuario.dto.UsuarioLoginDto;
import dev.call.appointment.infra.security.TokenJwtDto;
import dev.call.appointment.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDetailsDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAll());
    }

    @PostMapping
    public ResponseEntity<UsuarioDetailsDto> save(@Valid @RequestBody UsuarioCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.save(dto));
    }

    @PostMapping("login")
    public ResponseEntity<TokenJwtDto> login(@Valid @RequestBody UsuarioLoginDto dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new TokenJwtDto(usuarioService.login(dto)));
    }
}
