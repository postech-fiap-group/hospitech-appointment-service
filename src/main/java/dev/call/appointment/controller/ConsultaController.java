package dev.call.appointment.controller;



import dev.call.appointment.domain.consulta.dto.ConsultaCreateDto;
import dev.call.appointment.domain.consulta.dto.ConsultaDto;
import dev.call.appointment.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(consultaService.getAll());
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ConsultaDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(consultaService.getById(id));
    }

    @GetMapping("/new")
    public ResponseEntity<ConsultaDto> save(@Valid @RequestBody ConsultaCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(consultaService.save(dto));
    }

    @PutMapping({"{id}/edit"})
    public ResponseEntity<ConsultaDto> update(@PathVariable("id") Long id, @Valid @RequestBody ConsultaCreateDto dto) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(consultaService.update(id,dto));
    }

    @DeleteMapping({"{id}/delete"})
    public ResponseEntity<ConsultaDto> delete(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
