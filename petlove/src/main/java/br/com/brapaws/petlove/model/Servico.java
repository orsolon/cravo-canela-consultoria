package br.com.brapaws.petlove.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServico;
	
	private String nomeServico;
	
	private String descricao;
	
	private Double valorServico;
	
	private LocalTime tempoServico;

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idService) {
		this.idServico = idService;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorServico() {
		return valorServico;
	}

	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}

	public LocalTime getTempoServico() {
		return tempoServico;
	}

	public void setTempoServico(LocalTime tempoServico) {
		this.tempoServico = tempoServico;
	}

}
