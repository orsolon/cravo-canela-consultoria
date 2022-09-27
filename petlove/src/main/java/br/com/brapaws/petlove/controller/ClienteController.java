package br.com.brapaws.petlove.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.brapaws.petlove.model.Cliente;
import br.com.brapaws.petlove.service.IClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping("/clientes")
	public ArrayList<Cliente> recuperarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> buscarPeloId(@PathVariable Integer id){
		Cliente res = service.buscarPeloID(id);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> inserirNovo(@RequestBody Cliente novo){
		Cliente res = service.criarCliente(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/clientes")
	public ResponseEntity<Cliente> alterar(@RequestBody Cliente dados){
		Cliente res = service.atualizarCliente(dados);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Cliente> excliurCliente(@PathVariable Integer id){
		service.deletarCliente(id);
		return ResponseEntity.ok(null);
	}
	
}
