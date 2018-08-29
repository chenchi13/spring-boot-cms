package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Page;
import com.example.demo.repository.PageRepository;

@RestController
@RequestMapping("/api/page")
public class PageRestController {

	@Autowired
	private PageRepository pageJpaRepository;
	
	@GetMapping(value="/all")
	public List<Page> findAll() {
		return pageJpaRepository.findAll();
	}
	
	@GetMapping(value="/findById/{id}")
	public Optional<Page> findById(@PathVariable final Long id) {
		return pageJpaRepository.findById(id);
	}
	
	@PostMapping(value = "/save")
	public boolean save(@RequestBody final Page page)
	{
		pageJpaRepository.save(page);
		return true;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
	public void delete(@PathVariable final Long id)
	{
		pageJpaRepository.deleteById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public void update(@RequestBody final Page page)
	{
		pageJpaRepository.save(page);	
	}
	
}
