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

import com.ProjetojpaControle_de_Ligacoes.Services.LigacaoService;
import com.ProjetojpaControle_de_Ligacoes.entities.Ligacao;


@RestController
@RequestMapping("/Ligacao")
public class LigacaoController {
	private final LigacaoService LigacaoService;

	@Autowired
	public LigacaoController(LigacaoService ligacaoService) {
		this.LigacaoService = ligacaoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ligacao> buscaLigacaoControlId(@PathVariable long id) {
		Ligacao ligacao = LigacaoService.buscaLigacaoId(id);
		if (ligacao != null)
			return ResponseEntity.ok(ligacao);
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Ligacao>> buscaTodosLigacaoControl() {
		List<Ligacao> Ligacao = LigacaoService.buscaTodosLigacao();
		return ResponseEntity.ok(Ligacao);
	}

	@PostMapping("/")
	public ResponseEntity<Ligacao> salvaLigacaoControl(@RequestBody Ligacao ligacao) {
		Ligacao salvaLigacao = LigacaoService.salvaLigacao(ligacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaLigacao);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ligacao> alteraLigacaoControl(@PathVariable long id, @RequestBody Ligacao ligacao) {
		Ligacao alteraLigacao = LigacaoService.alterarLigacao(id, ligacao);
		if (alteraLigacao != null) {
			return ResponseEntity.ok(ligacao);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaLigacaoControl(@PathVariable long id) {
		boolean apagar = LigacaoService.apagarLigacao(id);
		if (apagar) {
			return ResponseEntity.ok().body("a Ligacao foi excluida com sucesso");
		} else {
			return ResponseEntity.notFound().build();

		}
	}
}