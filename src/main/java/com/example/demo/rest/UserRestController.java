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

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserRepository userJpaRepository;
	
	@GetMapping(value="/all")
	public List<User> findAll() {
		return userJpaRepository.findAll();
	}
	
	@GetMapping(value="/findById/{id}")
	public Optional<User> findById(@PathVariable final Long id) {
		return userJpaRepository.findById(id);
	}
	
	@GetMapping(value="/findByUsername/{name}")
	public User findByUsername(@PathVariable final String name) {
		return userJpaRepository.findByUsername(name);
	}
	
	// ako pošaljem postojeći id ponaša se kao update, 
	// ako omitam id onda se ponaša kao post
	@PostMapping(value = "/save")
	public User save(@RequestBody final User user)
	{
		userJpaRepository.save(user);
		return userJpaRepository.findByUsername(user.getUsername());
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
	public void delete(@PathVariable final Long id)
	{
		userJpaRepository.deleteById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public void update(@RequestBody final User user)
	{
		userJpaRepository.save(user);	
	}
	
}
