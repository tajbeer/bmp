package com.bmp.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmp.demo.model.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long>{
	
	List<Publication> findByAuthor_Name_AndYear(String name, String year);
	List<Publication> findByAuthor_Name_AndType(String name, String type);

}
