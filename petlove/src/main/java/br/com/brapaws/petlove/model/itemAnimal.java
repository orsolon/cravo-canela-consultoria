package br.com.brapaws.petlove.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class itemAnimal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seq;
	
	@ManyToOne
	@JoinColumn(name = "idPedido")
	@JsonIgnoreProperties("pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "idAnimal")
	@JsonIgnoreProperties("cliente")
	private Animal animal;
	
	@ManyToOne
	@JoinColumn(name = "idServico")
	@JsonIgnoreProperties("servico")
	private Servico servico;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
}
