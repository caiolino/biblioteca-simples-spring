package com.biblioteca.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.model.Livros;
import com.biblioteca.biblioteca.repository.LivrosRepository;


@RestController
@RequestMapping("/livros")
@CrossOrigin("*")
public class LivrosConreoller {
	
	@Autowired
	private LivrosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Livros>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Livros> GetbyId(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/livro/{livro}")
	public ResponseEntity<List<Livros>> Getbylivro(@PathVariable String livro){
		return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(livro));
	}
	
	@PostMapping
	public ResponseEntity<Livros> post (@RequestBody Livros Livros){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Livros));
	}
	
	@PutMapping
	public ResponseEntity<Livros> put (@RequestBody Livros Livros){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Livros));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	

}
