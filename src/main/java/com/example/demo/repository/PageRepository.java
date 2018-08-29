package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Page;

@Component
public interface PageRepository extends JpaRepository<Page, Long>{
	
	Page findByTitle(String title);
	
}
