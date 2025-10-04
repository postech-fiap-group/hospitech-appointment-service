package dev.call.appointment.service;

import dev.call.appointment.commands.NotificarCommand;
import dev.call.appointment.domain.consulta.Consulta;
import dev.call.appointment.domain.consulta.Especialidade;
import dev.call.appointment.domain.consulta.dto.ConsultaCreateDto;
import dev.call.appointment.domain.consulta.dto.ConsultaDto;
import dev.call.appointment.domain.usuario.TipoUsuario;
import dev.call.appointment.domain.usuario.Usuario;
import dev.call.appointment.exception.ConsultaCamposInvalidosException;
import dev.call.appointment.exception.ConsultaNotFoundException;
import dev.call.appointment.exception.MedicoInvalidosException;
import dev.call.appointment.exception.PacienteInvalidosException;
import dev.call.appointment.repository.ConsultaRepository;
import dev.call.appointment.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final Validator validator;
    private final UsuarioRepository usuarioRepository;
    private final NotificarService notificarService;

    public ConsultaService(ConsultaRepository consultaRepository, Validator validator, UsuarioRepository usuarioRepository,
                           NotificarService notificarService) {
        this.consultaRepository = consultaRepository;
        this.validator = validator;
        this.usuarioRepository = usuarioRepository;
        this.notificarService = notificarService;
    }

    public List<ConsultaDto> getAll() {
        List<Consulta> consultas = consultaRepository.findAll();
        return consultas.stream().map(ConsultaDto::new).toList();
    }

    public ConsultaDto save(@Valid ConsultaCreateDto dto) {
        verificacaoDto(dto);
        Usuario medicoEncontrado = usuarioRepository.findByIdAndTipo(dto.medicoId(), TipoUsuario.MEDICO).orElseThrow(MedicoInvalidosException::new);
        Usuario pascienteEncontrado = usuarioRepository.findByIdAndTipo(dto.pacienteId(), TipoUsuario.PACIENTE).orElseThrow(PacienteInvalidosException::new);
        Consulta consultaSalva = consultaRepository.save(builderNovaConsulta(dto, medicoEncontrado, pascienteEncontrado));
        sendNotification(consultaSalva, medicoEncontrado, pascienteEncontrado);
        return new ConsultaDto(consultaSalva);
    }

    public ConsultaDto getById(Long id) {
        Consulta consultaEncontrada = consultaRepository.findById(id).orElseThrow(ConsultaNotFoundException::new);
        return new ConsultaDto(consultaEncontrada);
    }

    public ConsultaDto update(Long id, ConsultaCreateDto dto) {
        verificacaoDto(dto);
        Consulta consultaEncontrada = consultaRepository.findById(id).orElseThrow(ConsultaNotFoundException::new);
        Usuario medicoEncontrado = usuarioRepository.findByIdAndTipo(dto.medicoId(), TipoUsuario.MEDICO).orElseThrow(MedicoInvalidosException::new);
        Usuario pascienteEncontrado = usuarioRepository.findByIdAndTipo(dto.pacienteId(), TipoUsuario.PACIENTE).orElseThrow(PacienteInvalidosException::new);

        builderAtualizaConsulta(consultaEncontrada, dto, medicoEncontrado, pascienteEncontrado);

        sendNotification(consultaEncontrada, medicoEncontrado, pascienteEncontrado);

        return new ConsultaDto(consultaRepository.save(consultaEncontrada));
    }

    private void builderAtualizaConsulta(Consulta consultaEncontrada, ConsultaCreateDto dto, Usuario medicoEncontrado, Usuario pascienteEncontrado) {
        consultaEncontrada.setMedicoId(medicoEncontrado);
        consultaEncontrada.setPacienteId(pascienteEncontrado);
        consultaEncontrada.setEspecialidade(Especialidade.valueOf(dto.especialidade()));
        consultaEncontrada.setDataHoraConsulta(LocalDateTime.parse(dto.dataHora()));
        consultaEncontrada.setObservacoes(dto.observacoes());
    }

    private void verificacaoDto(Object dto) {
        var erros = this.validator.validateObject(dto)
                .getAllErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toSet());

        if (!erros.isEmpty()) {
            throw new ConsultaCamposInvalidosException(erros);
        }
    }

    private Consulta builderNovaConsulta(@Valid ConsultaCreateDto dto, Usuario medicoEncontrado, Usuario pascienteEncontrado) {
        return new Consulta(
                medicoEncontrado,
                pascienteEncontrado,
                Especialidade.valueOf(dto.especialidade()),
                LocalDateTime.parse(dto.dataHora(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                dto.observacoes()
        );
    }

    private void sendNotification(Consulta consulta, Usuario medicoEncontrado, Usuario pascienteEncontrado) {
        notificarService.newNotitification(new NotificarCommand(
                pascienteEncontrado.getNome(),
                pascienteEncontrado.getEmail(),
                consulta.getEspecialidade().name(),
                consulta.getDataHoraConsulta().toLocalDate(),
                medicoEncontrado.getNome()));

    }

}
