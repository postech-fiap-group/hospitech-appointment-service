package dev.call.appointment.service;

import dev.call.appointment.domain.consulta.Consulta;
import dev.call.appointment.domain.consulta.Especialidade;
import dev.call.appointment.domain.consulta.dto.ConsultaCreateDto;
import dev.call.appointment.domain.consulta.dto.ConsultaDto;
import dev.call.appointment.domain.usuario.Usuario;
import dev.call.appointment.exception.ConsultaCamposInvalidosException;
import dev.call.appointment.exception.ConsultaNotFoundException;
import dev.call.appointment.exception.MedicoInvalidosException;
import dev.call.appointment.exception.PacienteInvalidosException;
import dev.call.appointment.infra.security.TokenService;
import dev.call.appointment.repository.ConsultaRepository;
import dev.call.appointment.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Character.toUpperCase;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final TokenService tokenService;
    private final Validator validator;
    private final UsuarioRepository usuarioRepository;
    private final RestClient.Builder builder;

    public ConsultaService(ConsultaRepository consultaRepository, TokenService tokenService, Validator validator, UsuarioRepository usuarioRepository, RestClient.Builder builder) {
        this.consultaRepository = consultaRepository;
        this.tokenService = tokenService;
        this.validator = validator;
        this.usuarioRepository = usuarioRepository;
        this.builder = builder;
    }

    public List<ConsultaDto> getAll() {
        List<Consulta> consultas = consultaRepository.findAll();
        return consultas.stream().map(consulta -> new ConsultaDto(consulta)).collect(Collectors.toList());
    }

    public ConsultaDto save(@Valid ConsultaCreateDto dto) {
        verificacaoDto(dto);
        Consulta consultaSalva = consultaRepository.save(builderConsulta(dto));
        return new ConsultaDto(consultaSalva);
    }

    public ConsultaDto getById(Long id) {
        Consulta consultaEncontrada = consultaRepository.findById(id).orElseThrow(ConsultaNotFoundException::new);
        return new ConsultaDto(consultaEncontrada);
    }

    public ConsultaDto update(@Valid ConsultaCreateDto dto) {
        return null;
    }

    private void verificacaoDto(Object dto) {
        var erros = this.validator.validateObject(dto)
                .getAllErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toSet());

        if (!erros.isEmpty()) {
            throw new ConsultaCamposInvalidosException(erros);
        }
    }

    private Consulta builderConsulta(@Valid ConsultaCreateDto dto) {
        Usuario medicoEncontrado = usuarioRepository.findById(dto.medicoId()).orElseThrow(MedicoInvalidosException::new);
        Usuario pascienteEncontrado = usuarioRepository.findById(dto.pacienteId()).orElseThrow(PacienteInvalidosException::new);
        return new Consulta(
                medicoEncontrado,
                pascienteEncontrado,
                Especialidade.valueOf(dto.especialidade().toUpperCase()),
                LocalDateTime.parse(dto.dataHora()),
                dto.observacoes()
        );
    }

}
