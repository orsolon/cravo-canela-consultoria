package br.com.brapaws.petlove.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.brapaws.petlove.model.Endereco;

public interface EnderecoDAO extends CrudRepository<Endereco, Integer>{
	
}
