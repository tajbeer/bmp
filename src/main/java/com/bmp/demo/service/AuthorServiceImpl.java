package com.bmp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bmp.demo.model.Author;

import repository.AuthorRepository;

public class AuthorServiceImpl implements AuthorService {
	
	private AuthorRepository repository;

	@Autowired
	public AuthorServiceImpl(AuthorRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Author> findAllAuthors() {
		return repository.findAll();	}

	@Override
	public Author save(Author newAuthor) {
		return repository.save(newAuthor);
	}

	@Override
	public Optional<Author> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
