package br.com.brapaws.petlove.service;

import java.util.ArrayList;

import br.com.brapaws.petlove.model.Cliente;

public interface IClienteService {
	
	public Cliente criarCliente(Cliente novo);
	public Cliente atualizarCliente(Cliente dados);
	public void deletarCliente(Integer id);
	public Cliente buscarPeloID(Integer id);
	public ArrayList<Cliente> buscarTodos();

}
