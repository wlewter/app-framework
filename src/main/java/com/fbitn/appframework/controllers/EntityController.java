package com.fbitn.appframework.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fbitn.appframework.model.Entity;
import com.fbitn.appframework.repository.EntityRepository;

@RestController
@RequestMapping(value="/entity")
public class EntityController {

	private EntityRepository entityRepo;
	
	public EntityController(EntityRepository entityRepo) {
		this.entityRepo = entityRepo;
	}

	@GetMapping
	public ResponseEntity<List<Entity>> getAll() {
		return ResponseEntity.ok().body(entityRepo.getAll());
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Entity> getOne(@PathVariable(name="name") String name) {
		return ResponseEntity.ok().body(entityRepo.getOne(name));
	}
	
	@PostMapping 
	public ResponseEntity<?> insertOne(@RequestBody Entity entity) {
		
		entityRepo.insertOne(entity);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{name}")
				.buildAndExpand(entity.getName()).toUri();		
		return ResponseEntity.created(location).build();
	}
}
