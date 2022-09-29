package br.com.brapaws.petlove.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brapaws.petlove.dao.AnimalDAO;
import br.com.brapaws.petlove.model.Animal;


@Service
public class AnimalServiceImpl implements IAnimalService{

	@Autowired
	private AnimalDAO dao;
	
	@Override
	public ArrayList<Animal> recuperarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Animal>)dao.findAll();
	}

	@Override
	public Animal recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public Animal criarAnimal(Animal novo) {
		// TODO Auto-generated method stub
		if(novo.getNome() != null) {
			return dao.save(novo);
		}
		return null;
	}

	@Override
	public Animal atualizarAnimal(Animal dados) {
		// TODO Auto-generated method stub
		if(dados.getIdAnimal() != null && dados.getNome() != null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public void deletarAnimal(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
