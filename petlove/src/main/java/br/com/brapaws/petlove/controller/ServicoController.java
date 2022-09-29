package br.com.brapaws.petlove.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.brapaws.petlove.model.Servico;
import br.com.brapaws.petlove.service.IServicoService;

@CrossOrigin("*")
@RestController
public class ServicoController {
	
	@Autowired
	private IServicoService service;
	
	@GetMapping("/servicos")
	public ArrayList<Servico> recuperarTodos(){
		return service.recuperarTodos();
	}
	
	@GetMapping("/servicos/{id}")
	public ResponseEntity<Servico> buscarPeloId(@PathVariable Integer id){
		Servico res = service.recuperarPeloId(id);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/servicos")
	public ResponseEntity<Servico> inserirNovo(@RequestBody Servico novo){
		Servico res = service.criarServico(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/servicos")
	public ResponseEntity<Servico> alterar(@RequestBody Servico dados){
		Servico res = service.atualizarServico(dados);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/servicos/{id}")
	public ResponseEntity<Servico> excliurEndereco(@PathVariable Integer id){
		service.deletarServico(id);
		return ResponseEntity.ok(null);
	}

}
