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

import br.com.brapaws.petlove.model.Endereco;
import br.com.brapaws.petlove.service.IEnderecoService;

@RestController
public class EnderecoController {
	
	@Autowired
	private IEnderecoService service;
	
	@GetMapping("/enderecos")
	public ArrayList<Endereco> recuperarTodos(){
		return service.recuperarTodos();
	}
	
	@GetMapping("/enderecos/{id}")
	public ResponseEntity<Endereco> buscarPeloId(@PathVariable Integer id){
		Endereco res = service.recuperarPeloId(id);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/enderecos")
	public ResponseEntity<Endereco> inserirNovo(@RequestBody Endereco novo){
		Endereco res = service.criarEndereco(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/enderecos")
	public ResponseEntity<Endereco> alterar(@RequestBody Endereco dados){
		Endereco res = service.atualizarEndereco(dados);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/enderecos/{id}")
	public ResponseEntity<Endereco> excliurEndereco(@PathVariable Integer id){
		service.deletarEndereco(id);
		return ResponseEntity.ok(null);
	}

}
