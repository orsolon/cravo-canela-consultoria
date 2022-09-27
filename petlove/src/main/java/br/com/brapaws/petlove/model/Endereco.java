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
@Table (name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_endereco")
	private Integer idEndereco;
	
	@Column (name = "cep", length = 10, nullable = false)
	private String cep;
	
	@Column (name = "rua", length = 100, nullable = false)
	private String rua;
	
	@Column (name = "numero", nullable = false)
	private Integer numero;
	
	@Column (name = "complemento", length = 45, nullable = true)
	private String complemento;
	
	@Column (name = "bairro", length = 30, nullable = false)
	private String bairro;
	
	@Column (name = "cidade", length = 30, nullable = false)
	private String cidade;
	
	@Column (name = "estado", length = 2, nullable = false)
	private String estado;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@JsonIgnoreProperties("listaEndereco")
	private Cliente cliente;

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
