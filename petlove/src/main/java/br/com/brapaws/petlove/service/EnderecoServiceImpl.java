package br.com.brapaws.petlove.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brapaws.petlove.dao.EnderecoDAO;
import br.com.brapaws.petlove.model.Endereco;

@Service
public class EnderecoServiceImpl implements IEnderecoService {

	@Autowired
	private EnderecoDAO dao;
	
	@Override
	public ArrayList<Endereco> recuperarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Endereco>)dao.findAll();
	}

	@Override
	public Endereco recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public Endereco criarEndereco(Endereco novo) {
		// TODO Auto-generated method stub
		if(novo.getCep() != null) {
			return dao.save(novo);
		}
		return null;
	}

	@Override
	public Endereco atualizarEndereco(Endereco dados) {
		// TODO Auto-generated method stub
		if(dados.getIdEndereco() != null && dados.getCep() != null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public void deletarEndereco(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
