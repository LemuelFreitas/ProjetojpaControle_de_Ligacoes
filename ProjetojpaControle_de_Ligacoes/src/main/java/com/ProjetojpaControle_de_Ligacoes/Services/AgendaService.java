package com.ProjetojpaControle_de_Ligacoes.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetojpaControle_de_Ligacoes.Repository.AgendaRepository;
import com.ProjetojpaControle_de_Ligacoes.entities.Agenda;

@Service
public class AgendaService {
	private final AgendaRepository agendaRepository;
	
	@Autowired
	public AgendaService(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}

	public List<Agenda> buscaTodosAgenda() {
		return agendaRepository.findAll();
	}

	public Agenda buscaAgendaId(long id) {
		Optional<Agenda> Agenda = agendaRepository.findById(id);
		return Agenda.orElse(null);
	}

	
	public Agenda salvaAgenda(Agenda agenda) {
		return agendaRepository.save(agenda);
	}

	public Agenda alterarAgenda(long id, Agenda alterarAgenda) {
		Optional<Agenda> existeAgenda = agendaRepository.findById(id);
		if (existeAgenda.isPresent()) {
			alterarAgenda.setId(id);
			return agendaRepository.save(alterarAgenda);

		}
		return null;
	}
	public boolean apagarAgenda(long id) {
		Optional<Agenda> existeAgenda = agendaRepository.findById(id);
		if (existeAgenda.isPresent() ) {
			agendaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}