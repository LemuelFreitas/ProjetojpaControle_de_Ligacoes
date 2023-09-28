package com.ProjetojpaControle_de_Ligacoes.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetojpaControle_de_Ligacoes.entities.Ligacao;

public interface LigacaoRepository extends JpaRepository<Ligacao, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}