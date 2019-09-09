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

import com.bmp.demo.model.Publication;
import com.bmp.demo.service.PublicationService;

@RestController
@RequestMapping(value = "/publication-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class PublicationController {

	private PublicationService service;

	@Autowired
	public PublicationController(PublicationService service) {
		this.service = service;

	}

	@GetMapping(value = "/publications")
	public List<Publication> getPublications() {
		return service.findAllPublication();
	}

	@PostMapping("/publications")
	Publication createOrSavePulication(@RequestBody Publication publication) {
		return service.save(publication);
	}

	@GetMapping("/publications/{id}")
	Publication getPulicationById(@PathVariable Long id) {
		return service.findById(id).get();
	}

	@PutMapping("/publications/{id}")
	Publication updateAuthor(@RequestBody Publication publication, @PathVariable Long id) {
		return service.findById(id).map(a -> {
			a.setTitle(publication.getTitle());
			a.setHero(publication.getHero());
			a.setType(publication.getType());
			a.setGenre(publication.getGenre());
			a.setYear(publication.getYear());
			return service.save(a);
		}).orElseGet(() -> {
			publication.setId(id);
			return service.save(publication);
		});

	}
	

	@DeleteMapping("/publications/{id}")
	void deletePulication(@PathVariable Long id) {
		service.deleteById(id);
	}

	@GetMapping("/publications/{author_name}/{year}")
	List<Publication> getPulicationByAuthorAndYear(@PathVariable String author_name, @PathVariable String year) {
		return service.findAllPublicationByAuthorAndYear(author_name, year);
	}
	
	@GetMapping("/publications/{author_name}/{type}")
	List<Publication> getPulicationByAuthorAndType(@PathVariable String author_name, @PathVariable String type) {
		return service.findAllPublicationByAuthorAndType(author_name, type);
	}
}
