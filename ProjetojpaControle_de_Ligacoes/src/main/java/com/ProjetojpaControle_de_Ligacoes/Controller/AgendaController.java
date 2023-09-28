package com.ProjetojpaControle_de_Ligacoes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetojpaControle_de_Ligacoes.Services.AgendaService;
import com.ProjetojpaControle_de_Ligacoes.entities.Agenda;

@RestController
@RequestMapping("/Agenda")
public class AgendaController {
	private final AgendaService AgendaService;

	@Autowired
	public AgendaController(AgendaService agendaService) {
		this.AgendaService = agendaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Agenda> buscaAgendaControlId(@PathVariable long id) {
		Agenda agenda = AgendaService.buscaAgendaId(id);
		if (agenda != null)
			return ResponseEntity.ok(agenda);
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Agenda>> buscaTodosAgendaControl() {
		List<Agenda> Agenda = AgendaService.buscaTodosAgenda();
		return ResponseEntity.ok(Agenda);
	}

	@PostMapping("/")
	public ResponseEntity<Agenda> salvaTarefaControl(@RequestBody Agenda agenda) {
		Agenda salvaAgenda = AgendaService.salvaAgenda(agenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAgenda);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Agenda> alteraAgendaControl(@PathVariable long id, @RequestBody Agenda agenda) {
		Agenda alteraAgenda = AgendaService.alterarAgenda(id, agenda);
		if (alteraAgenda != null) {
			return ResponseEntity.ok(agenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAgendaControl(@PathVariable long id) {
		boolean apagar = AgendaService.apagarAgenda(id);
		if (apagar) {
			return ResponseEntity.ok().body("a Agenda foi excluida com sucesso");
		} else {
			return ResponseEntity.notFound().build();

		}
	}
}
