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

import com.fbitn.appframework.model.view.Page;
import com.fbitn.appframework.repository.PageRepository;

@RestController
@RequestMapping(value="/page")
public class PageController {

	private PageRepository pageRepo;
	
	public PageController(PageRepository pageRepo) {
		this.pageRepo = pageRepo;
	}

	@GetMapping
	public ResponseEntity<List<Page>> getAll() {
		return ResponseEntity.ok().body(pageRepo.getAll());
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Page> getOne(@PathVariable(name="name") String name) {
		return ResponseEntity.ok().body(pageRepo.getOne(name));
	}
	
	@PostMapping 
	public ResponseEntity<?> insertOne(@RequestBody Page page) {
		
		pageRepo.insertOne(page);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{name}")
				.buildAndExpand(page.getName()).toUri();		
		return ResponseEntity.created(location).build();
	}
}
