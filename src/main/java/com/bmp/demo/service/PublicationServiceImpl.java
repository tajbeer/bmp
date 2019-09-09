package com.bmp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bmp.demo.model.Publication;

import repository.PublicationRepository;

public class PublicationServiceImpl implements PublicationService {

	private PublicationRepository repository;

	@Autowired
	public PublicationServiceImpl(PublicationRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Publication> findAllPublication() {
		return repository.findAll();
	}

	@Override
	public Publication save(Publication publication) {
		return repository.save(publication);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Publication> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Publication> findAllPublicationByAuthorAndYear(String name, String year) {
		return repository.findByAuthor_Name_AndYear(name, year);
	}

	@Override
	public List<Publication> findAllPublicationByAuthorAndType(String name, String type) {
		// TODO Auto-generated method stub
		return repository.findByAuthor_Name_AndType(name, type);
	}

}
