package dev.call.appointment.controller;

import dev.call.appointment.commands.NotificarCommand;
import dev.call.appointment.domain.notificacao.dto.NotificationDTO;
import dev.call.appointment.service.NotificarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificacaoes")
public class NotificarController {

	private final NotificarService notificarService;

	public NotificarController(NotificarService notificarService) {
		this.notificarService = notificarService;
	}

	@PostMapping("/new")
	public ResponseEntity<String> newNotification(@RequestBody NotificationDTO dto){
		notificarService.newNotitification(new NotificarCommand(dto.pacienteNome(),dto.pacienteEmail(),
				dto.especialidadeConsulta(), dto.dataConsulta(), dto.medicoNome()));

		return ResponseEntity.ok("Notificação enviada para a queue");
	}
}
