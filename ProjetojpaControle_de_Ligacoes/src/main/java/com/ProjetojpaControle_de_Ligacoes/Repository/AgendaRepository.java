package com.ProjetojpaControle_de_Ligacoes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetojpaControle_de_Ligacoes.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}