package com.bmp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bmp.demo.model.Author;

@Service
public interface AuthorService {

	List<Author> findAllAuthors();

	Author save(Author newAuthor);

	Optional<Author> findById(Long id);

	void deleteById(Long id);

}
