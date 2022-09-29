package br.com.brapaws.petlove.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brapaws.petlove.dao.ClienteDAO;
import br.com.brapaws.petlove.model.Cliente;



@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private ClienteDAO dao;

	@Override
	public Cliente criarCliente(Cliente novo) {
		// TODO Auto-generated method stub
		if(novo.getNome() != null) {
			return dao.save(novo);
		}
		return null;
	}

	@Override
	public Cliente atualizarCliente(Cliente dados) {
		// TODO Auto-generated method stub
		if (dados.getIdCliente() != null && dados.getNome() != null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public void deletarCliente(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Cliente buscarPeloID(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public ArrayList<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Cliente>)dao.findAll();
	}

}
