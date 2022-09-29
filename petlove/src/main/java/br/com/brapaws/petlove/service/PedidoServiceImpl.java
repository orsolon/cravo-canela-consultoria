package br.com.brapaws.petlove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brapaws.petlove.dao.PedidoDAO;
import br.com.brapaws.petlove.model.Pedido;
import br.com.brapaws.petlove.model.itemAnimal;



@Service
public class PedidoServiceImpl implements IPedidoService{

	@Autowired
	private PedidoDAO dao;
	
	@Override
	public Pedido inserirNovo(Pedido novo) {
		// TODO Auto-generated method stub
		for(itemAnimal item: novo.getItens()) {
			item.setPedido(novo);
		}
		return dao.save(novo);
	}

	@Override
	public Pedido recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

}
