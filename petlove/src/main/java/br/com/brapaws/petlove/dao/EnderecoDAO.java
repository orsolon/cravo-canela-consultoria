package br.com.brapaws.petlove.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brapaws.petlove.model.Endereco;

public interface EnderecoDAO extends JpaRepository<Endereco, Integer>{
	
}
