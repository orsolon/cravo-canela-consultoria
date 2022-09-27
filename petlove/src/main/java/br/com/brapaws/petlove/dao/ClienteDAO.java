package br.com.brapaws.petlove.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.brapaws.petlove.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer>{

}
