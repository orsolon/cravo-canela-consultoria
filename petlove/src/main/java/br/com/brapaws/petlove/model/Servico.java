package br.com.brapaws.petlove.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "servico")
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_servico")
	private Integer idServico;
	
	@Column (name = "nome_servico", length = 15, nullable = false)
	private String nomeServico;
	
	@Column (name = "descricao", columnDefinition = "TEXT", nullable = false)
	private String descricao;
	
	@Column (name = "valor_servico", nullable = false)
	private Double valorServico;
	
	@Column (name = "tempo_servico", length = 15, nullable = false)
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
