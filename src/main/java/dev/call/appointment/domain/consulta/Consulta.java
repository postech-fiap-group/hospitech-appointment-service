package dev.call.appointment.domain.consulta;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pacienteId;
    private Long medicoId;
    @Enumerated(EnumType.STRING)
    private List<Especialidade> especialidade;
    private LocalDateTime dataHoraConsulta;
    private String observacoes;

    public Consulta() {
    }

    public Consulta(Long id, Long pacienteId, Long medicoId, List<Especialidade> especialidade, LocalDateTime dataHoraConsulta, String observacoes) {
        this.id = id;
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

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public List<Especialidade> getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(List<Especialidade> especialidade) {
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
}


