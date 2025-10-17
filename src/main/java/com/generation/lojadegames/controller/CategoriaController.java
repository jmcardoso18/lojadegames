package com.generation.lojadegames.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojadegames.model.Categoria;
import com.generation.lojadegames.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins ="*",allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping //Select*from td_postagens
	public ResponseEntity<List<Categoria>> getall(){
		return ResponseEntity.ok(categoriaRepository.findAll());

	}
	
	@GetMapping("/{id}")// Procurando por ID
	public ResponseEntity<Categoria> getByid(@PathVariable Long id){
		return categoriaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> getAllByNome(@PathVariable String nome){
		return ResponseEntity.ok(categoriaRepository.findAllByNomeContainingIgnoreCase(nome));
		
	}
	
	@PostMapping
    public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria) {
        Categoria novo = categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
	
	@PutMapping
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria) {
	    return categoriaRepository.findById(categoria.getId())
	            .map(resposta -> ResponseEntity.status(HttpStatus.OK)
	                    .body(categoriaRepository.save(categoria)))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		categoriaRepository.deleteById(id);
		
	}
} 
