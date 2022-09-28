package br.com.brapaws.petlove.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer idPedido;
	
	private LocalDate dataPedido;
	
	private LocalTime horarioPedido;
	
	private Integer quantAnimal;
	
	private LocalTime horarioBusca;
	
	private LocalTime horarioEntrega;
	
	private String status;
	
	private Double precoInicial;
	
	private Double precoFinal;
	
	private Double desconto;
	
	private LocalTime tempoExecucao;
	
	private String formaPagto;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	@JsonIgnoreProperties({"listaEndereco", "listaAnimal"})
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pedido")
	private List<itemAnimal> itens;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalTime getHorarioPedido() {
		return horarioPedido;
	}

	public void setHorarioPedido(LocalTime horarioPedido) {
		this.horarioPedido = horarioPedido;
	}

	public Integer getQuantAnimal() {
		return quantAnimal;
	}

	public void setQuantAnimal(Integer quantAnimal) {
		this.quantAnimal = quantAnimal;
	}

	public LocalTime getHorarioBusca() {
		return horarioBusca;
	}

	public void setHorarioBusca(LocalTime horarioBusca) {
		this.horarioBusca = horarioBusca;
	}

	public LocalTime getHorarioEntrega() {
		return horarioEntrega;
	}

	public void setHorarioEntrega(LocalTime horarioEntrega) {
		this.horarioEntrega = horarioEntrega;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrecoInicial() {
		return precoInicial;
	}

	public void setPrecoInicial(Double precoInicial) {
		this.precoInicial = precoInicial;
	}

	public Double getPrecoFinal() {
		return precoFinal;
	}

	public void setPrecoFinal(Double precoFinal) {
		this.precoFinal = precoFinal;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public LocalTime getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(LocalTime tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	public String getFormaPagto() {
		return formaPagto;
	}

	public void setFormaPagto(String formaPagto) {
		this.formaPagto = formaPagto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<itemAnimal> getItens() {
		return itens;
	}

	public void setItens(List<itemAnimal> itens) {
		this.itens = itens;
	}

}
