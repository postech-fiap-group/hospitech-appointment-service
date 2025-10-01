CREATE TABLE IF NOT EXISTS consulta
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    paciente_id        BIGINT                NOT NULL,
    medico_id          BIGINT                NOT NULL,
    especialidade ENUM('CARDIOLOGIA','PEDIATRIA','ORTOPEDIA','DERMATOLOGIA')  NOT NULL,
    data_hora_consulta datetime              NOT NULL,
    observacoes        VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_consulta PRIMARY KEY (id)
);

ALTER TABLE consulta
    ADD CONSTRAINT FK_CONSULTA_ON_MEDICO FOREIGN KEY (medico_id) REFERENCES usuario (id);

ALTER TABLE consulta
    ADD CONSTRAINT FK_CONSULTA_ON_PACIENTE FOREIGN KEY (paciente_id) REFERENCES usuario (id);