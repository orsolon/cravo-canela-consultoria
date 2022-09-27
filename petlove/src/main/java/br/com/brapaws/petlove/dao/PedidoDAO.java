package br.com.brapaws.petlove.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.brapaws.petlove.model.Pedido;


public interface PedidoDAO extends CrudRepository<Pedido, Integer>{

}
