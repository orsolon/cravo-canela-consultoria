package br.com.brapaws.petlove.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "item_animal")
public class itemAnimal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "seq")
	private Integer seq;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	@JsonIgnoreProperties("pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_animal")
	@JsonIgnoreProperties("cliente")
	private Animal animal;
	
	@ManyToOne
	@JoinColumn(name = "id_servico")
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
