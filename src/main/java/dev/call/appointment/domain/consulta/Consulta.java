package dev.call.appointment.domain.consulta;

import dev.call.appointment.domain.consulta.dto.ConsultaCreateDto;
import dev.call.appointment.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Usuario pacienteId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Usuario medicoId;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private LocalDateTime dataHoraConsulta;
    private String observacoes;

    public Consulta() {
    }

    public Consulta(Usuario pacienteId,
                    Usuario medicoId,
                    Especialidade especialidade,
                    LocalDateTime dataHoraConsulta,
                    String observacoes) {
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.especialidade = especialidade;
        this.dataHoraConsulta = dataHoraConsulta;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Usuario pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Usuario getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Usuario medicoId) {
        this.medicoId = medicoId;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void salvar(ConsultaCreateDto dto, Usuario medicoEncontrado, Usuario pascienteEncontrado) {
        this.pacienteId = pascienteEncontrado;
        this.medicoId = medicoEncontrado;
        this.dataHoraConsulta = dto.dataHora();
        this.observacoes = dto.observacoes();
        this.especialidade = dto.especialidade();
    }
}


