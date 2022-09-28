package br.com.brapaws.petlove.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brapaws.petlove.model.Pedido;


public interface PedidoDAO extends JpaRepository<Pedido, Integer>{

}
