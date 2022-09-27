package br.com.brapaws.petlove.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.brapaws.petlove.model.Animal;

public interface AnimalDAO extends CrudRepository<Animal, Integer> {

}
