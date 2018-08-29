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

import com.example.demo.model.MainMenu;
import com.example.demo.repository.MainMenuRepository;

@RestController
@RequestMapping("/api/mainmenu")
public class MainMenuRestController {

	@Autowired
	private MainMenuRepository mainMenuJpaRepository;
	
	@GetMapping(value="/all")
	public List<MainMenu> findAll() {
		return mainMenuJpaRepository.findAll();
	}
	
	@GetMapping(value="/findById/{id}")
	public Optional<MainMenu> findById(@PathVariable final Long id) {
		return mainMenuJpaRepository.findById(id);
	}
	
	@PostMapping(value = "/save")
	public boolean save(@RequestBody final MainMenu mainMenu)
	{
		mainMenuJpaRepository.save(mainMenu);
		return true;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
	public void delete(@PathVariable final Long id)
	{
		mainMenuJpaRepository.deleteById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public void update(@RequestBody final MainMenu mainMenu)
	{
		mainMenuJpaRepository.save(mainMenu);	
	}
	
}