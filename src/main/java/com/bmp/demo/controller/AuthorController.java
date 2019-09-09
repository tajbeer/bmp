package com.bmp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmp.demo.model.Author;
import com.bmp.demo.service.AuthorService;

@RestController
@RequestMapping(value = "/author-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AuthorController {

	private AuthorService service;

	@Autowired
	public AuthorController(AuthorService service) {
		this.service = service;

	}

	@GetMapping(value = "/authors")
	public List<Author> getAllAuthors() {
		return service.findAllAuthors();
	}

	@PostMapping("/authors")
	Author createOrSaveAuthor(@RequestBody Author newAuthor) {
		return service.save(newAuthor);
	}

	@GetMapping("/authors/{id}")
	Author getAuthorById(@PathVariable Long id) {
		return service.findById(id).get();
	}

	@PutMapping("/authors/{id}")
	Author updateAuthor(@RequestBody Author newAuthor, @PathVariable Long id) {
		return service.findById(id).map(a -> {
			a.setName(newAuthor.getName());
			return service.save(a);
		}).orElseGet(() -> {
			newAuthor.setId(id);
			return service.save(newAuthor);
		});

	}

	@DeleteMapping("/authors/{id}")
	void deleteAuthor(@PathVariable Long id) {
		service.deleteById(id);
	}

}
