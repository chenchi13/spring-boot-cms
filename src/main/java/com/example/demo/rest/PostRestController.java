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

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

@RestController
@RequestMapping("/api/post")
public class PostRestController {

	@Autowired
	private PostRepository postJpaRepository;
	
	@GetMapping(value="/all")
	public List<Post> findAll() {
		return postJpaRepository.findAll();
	}
	
	@GetMapping(value="/findById/{id}")
	public Optional<Post> findById(@PathVariable final Long id) {
		return postJpaRepository.findById(id);
	}
	
	@PostMapping(value = "/save")
	public boolean save(@RequestBody final Post post)
	{
		postJpaRepository.save(post);
		return true;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
	public void delete(@PathVariable final Long id)
	{
		postJpaRepository.deleteById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public void update(@RequestBody final Post post)
	{
		postJpaRepository.save(post);	
	}
}
