package com.bmp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmp.demo.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
