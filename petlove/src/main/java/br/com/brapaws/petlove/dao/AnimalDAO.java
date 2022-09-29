package br.com.brapaws.petlove.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brapaws.petlove.model.Animal;

public interface AnimalDAO extends JpaRepository<Animal, Integer> {

}
