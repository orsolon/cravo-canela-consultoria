package br.com.brapaws.petlove.service;

import br.com.brapaws.petlove.model.Pedido;

public interface IPedidoService {
	
	public Pedido inserirNovo(Pedido novo);
	public Pedido recuperarPeloId(Integer id);

}
