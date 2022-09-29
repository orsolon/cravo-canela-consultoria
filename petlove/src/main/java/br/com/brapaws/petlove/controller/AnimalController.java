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

import br.com.brapaws.petlove.model.Animal;
import br.com.brapaws.petlove.service.IAnimalService;

@CrossOrigin("*")
@RestController
public class AnimalController {
	
	@Autowired
	private IAnimalService service;
	
	@GetMapping("/animais")
	public ArrayList<Animal> recuperarTodos(){
		return service.recuperarTodos();
	}
	
	@GetMapping("/animais/{id}")
	public ResponseEntity<Animal> buscarPeloId(@PathVariable Integer id){
		Animal res = service.recuperarPeloId(id);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/animais")
	public ResponseEntity<Animal> inserirNovo(@RequestBody Animal novo){
		Animal res = service.criarAnimal(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/animais")
	public ResponseEntity<Animal> alterar(@RequestBody Animal dados){
		Animal res = service.atualizarAnimal(dados);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/animais/{id}")
	public ResponseEntity<Animal> excliurEndereco(@PathVariable Integer id){
		service.deletarAnimal(id);
		return ResponseEntity.ok(null);
	}

}
