package br.com.brapaws.petlove.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brapaws.petlove.model.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Integer>{

}
