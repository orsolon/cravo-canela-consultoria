package br.com.brapaws.petlove.service;

import java.util.ArrayList;

import br.com.brapaws.petlove.model.Endereco;

public interface IEnderecoService {
	
	public ArrayList<Endereco> recuperarTodos();
	public Endereco recuperarPeloId(Integer id);
	public Endereco criarEndereco(Endereco novo);
	public Endereco atualizarEndereco(Endereco dados);
	public void deletarEndereco(Integer id);
	
}
