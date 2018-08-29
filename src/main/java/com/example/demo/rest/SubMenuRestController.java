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

import com.example.demo.model.SubMenu;
import com.example.demo.repository.SubMenuRepository;

@RestController
@RequestMapping("/api/submenu")
public class SubMenuRestController {

	@Autowired
	private SubMenuRepository subMenuJpaRepository;
	
	@GetMapping(value="/all")
	public List<SubMenu> findAll() {
		return subMenuJpaRepository.findAll();
	}
	
	@GetMapping(value="/findById/{id}")
	public Optional<SubMenu> findById(@PathVariable final Long id) {
		return subMenuJpaRepository.findById(id);
	}
	
	@PostMapping(value = "/save")
	public boolean save(@RequestBody final SubMenu subMenu)
	{
		subMenuJpaRepository.save(subMenu);
		return true;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public void update(@RequestBody final SubMenu subMenu)
	{
		subMenuJpaRepository.save(subMenu);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
	public void delete(@PathVariable final Long id)
	{
		subMenuJpaRepository.deleteById(id);
	}
	
}