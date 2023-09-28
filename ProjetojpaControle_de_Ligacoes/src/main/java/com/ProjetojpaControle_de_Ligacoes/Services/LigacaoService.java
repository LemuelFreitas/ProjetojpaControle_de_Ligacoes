package com.ProjetojpaControle_de_Ligacoes.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetojpaControle_de_Ligacoes.Repository.LigacaoRepository;
import com.ProjetojpaControle_de_Ligacoes.entities.Ligacao;

@Service
public class LigacaoService {
	private final LigacaoRepository ligacaoRepository;
	
	@Autowired
	public LigacaoService(LigacaoRepository ligacaoRepository) {
		this.ligacaoRepository = ligacaoRepository;
	}

	public List<Ligacao> buscaTodosLigacao() {
		return ligacaoRepository.findAll();
	}

	public Ligacao buscaLigacaoId(long id) {
		Optional<Ligacao> Ligacao = ligacaoRepository.findById(id);
		return Ligacao.orElse(null);
	}

	
	public Ligacao salvaLigacao(Ligacao ligacao) {
		return ligacaoRepository.save(ligacao);
	}

	public Ligacao alterarLigacao(long id, Ligacao alterarLigacao) {
		Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id);
		if (existeLigacao.isPresent()) {
			alterarLigacao.setId(id);
			return ligacaoRepository.save(alterarLigacao);

		}
		return null;
	}
	public boolean apagarLigacao(long id) {
		Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id);
		if (existeLigacao.isPresent() ) {
			ligacaoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}