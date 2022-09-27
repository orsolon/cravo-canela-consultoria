package br.com.brapaws.petlove.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.brapaws.petlove.model.Pedido;
import br.com.brapaws.petlove.service.IPedidoService;




@RestController
public class PedidoController {
	
	@Autowired
	private IPedidoService service;
	
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> recuperarPeloNumero(@PathVariable Integer id){
		Pedido res = service.recuperarPeloId(id);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> inserirNovoPedido(@RequestBody Pedido novo){
		return ResponseEntity.ok(service.inserirNovo(novo));
	}
	
}
