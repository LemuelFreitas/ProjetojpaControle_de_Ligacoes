package com.ProjetojpaControle_de_Ligacoes.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Ligacao")
public class Ligacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name cannot be null")
	@Column
	private String data;
	
	@NotNull(message = "Name cannot be null")
	@Column
	private String horarioInicio;
	
	@NotNull(message = "Name cannot be null")
	@Column
	private String horarioTermino;
	
	@NotNull(message = "Name cannot be null")
	@Column
	private String telefoneDiscado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	
	public void setHorarioTermino(String horarioTermino) {
		this.horarioTermino = horarioTermino;
	}

	public String getHorarioTermino() {
		return horarioTermino;
	}
	
	public void setTelefoneDiscado(String telefoneDiscado) {
		this.telefoneDiscado = telefoneDiscado;
	}
	
	public String getTelefoneDiscado() {
		return telefoneDiscado;
	}
	

}