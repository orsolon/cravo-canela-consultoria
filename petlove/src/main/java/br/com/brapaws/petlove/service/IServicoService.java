package br.com.brapaws.petlove.service;

import java.util.ArrayList;

import br.com.brapaws.petlove.model.Servico;

public interface IServicoService {
	
	public ArrayList<Servico> recuperarTodos();
	public Servico recuperarPeloId(Integer id);
	public Servico criarServico(Servico novo);
	public Servico atualizarServico(Servico dados);
	public void deletarServico(Integer id);

}
