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

import com.fbitn.appframework.model.Subsystem;
import com.fbitn.appframework.repository.SubsystemRepository;

@RestController
@RequestMapping(value="/subsystem")
public class SubsystemController {

	private SubsystemRepository subsystemRepo;
	
	public SubsystemController(SubsystemRepository subsystemRepo) {
		this.subsystemRepo = subsystemRepo;
	}

	@GetMapping
	public ResponseEntity<List<Subsystem>> getAll() {
		return ResponseEntity.ok().body(subsystemRepo.getAll());
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Subsystem> getOne(@PathVariable(name="name") String name) {
		return ResponseEntity.ok().body(subsystemRepo.getOne(name));
	}
	
	@PostMapping 
	public ResponseEntity<?> insertOne(@RequestBody Subsystem subsystem) {
		
		subsystemRepo.insertOne(subsystem);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{name}")
				.buildAndExpand(subsystem.getName()).toUri();		
		return ResponseEntity.created(location).build();
	}
}
