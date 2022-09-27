package br.com.brapaws.petlove.service;

import java.util.ArrayList;

import br.com.brapaws.petlove.model.Animal;

public interface IAnimalService {
	
	public ArrayList<Animal> recuperarTodos();
	public Animal recuperarPeloId(Integer id);
	public Animal criarAnimal(Animal novo);
	public Animal atualizarAnimal(Animal dados);
	public void deletarAnimal(Integer id);

}
