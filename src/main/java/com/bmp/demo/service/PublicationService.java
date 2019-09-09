package com.bmp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bmp.demo.model.Publication;

@Service
public interface PublicationService {

	List<Publication> findAllPublication();

	Publication save(Publication publication);

	void deleteById(Long id);

	Optional<Publication> findById(Long id);
	
	List<Publication> findAllPublicationByAuthorAndYear(String name, String year);
	List<Publication> findAllPublicationByAuthorAndType(String name, String type);

	

}
