package br.com.brapaws.petlove.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brapaws.petlove.dao.ServicoDAO;
import br.com.brapaws.petlove.model.Animal;
import br.com.brapaws.petlove.model.Servico;

@Service
public class ServicoServiceImpl implements IServicoService {
	
	@Autowired
	private ServicoDAO dao;

	@Override
	public ArrayList<Servico> recuperarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Servico>)dao.findAll();
	}

	@Override
	public Servico recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public Servico criarServico(Servico novo) {
		// TODO Auto-generated method stub
		if(novo.getNomeServico() != null) {
			return dao.save(novo);
		}
		return null;
	}

	@Override
	public Servico atualizarServico(Servico dados) {
		// TODO Auto-generated method stub
		if(dados.getIdServico() != null && dados.getNomeServico() != null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public void deletarServico(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
