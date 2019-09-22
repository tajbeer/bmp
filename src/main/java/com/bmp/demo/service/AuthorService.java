package com.bmp.demo.service;

import java.util.List;
import java.util.Optional;

import com.bmp.demo.model.Author;


public interface AuthorService {

	List<Author> findAllAuthors();

	Author save(Author newAuthor);

	Optional<Author> findById(Long id);

	void deleteById(Long id);

}
