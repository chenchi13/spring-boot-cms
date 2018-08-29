package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Page;
import com.example.demo.model.Post;
import com.example.demo.repository.PageRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.viewmodels.PostViewModel;

@Controller
public class PostController {

	@Autowired
	PostRepository postRepository;
	@Autowired
	PageRepository pageRepository;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/allPosts")
	public String allPosts(Model model) {
		model.addAttribute("postViewModel", new PostViewModel());
		model.addAttribute("posts", postRepository.findAll());
		return "allPosts";
	}

	@GetMapping("/addNewPost")
	public String addNewPost(Model model) {
		model.addAttribute("postViewModel", new PostViewModel());
		model.addAttribute("pages", pageRepository.findAll());
		return "addNewPostDashboard";
	}
	
	@GetMapping("/addNewPost/{page_id}")
	public String addNewPost_OnPage(Model model, @PathVariable("page_id") Long pageId) {
		model.addAttribute("postViewModel", new PostViewModel(pageId));
		return "addNewPost";
	}

	@PostMapping("/addNewPost")
	public String saveNewPost(@ModelAttribute PostViewModel post, Model model) {
		postRepository.save(new Post(post.getTitle(), post.getText(), userRepository.findByUsername("solujic"), getPageById(post.getPageId())));

		return "redirect:/index/" + post.getPageId();
	}
	
	@GetMapping("/editPost/{post_id}")
	public String editPost(Model model, @PathVariable("post_id") Long id) {
		
		Post postToEdit = null;
		Optional<Post> postOptional = postRepository.findById(id);
		
		if(postOptional.isPresent())
		{
			postToEdit = postOptional.get();
		}
				
		PostViewModel postViewModel = new PostViewModel();
		postViewModel.setId(id);
		postViewModel.setTitle(postToEdit.getTitle());
		postViewModel.setText(postToEdit.getText());
		postViewModel.setPageId(postToEdit.getPage().getId());
		model.addAttribute("postViewModel", postViewModel);
		
		return "editPost";
	}

	@PostMapping("/editPost")
	public String saveEditedPost(@ModelAttribute PostViewModel post, Model model) {
		
		Page page = getPageById(post.getPageId());
		
		postRepository.save(new Post(post.getId(), post.getTitle(), post.getText(), userRepository.findByUsername("solujic"), page));

		return "redirect:/index/" + post.getPageId();
	}

	@RequestMapping(value = "/deletePost/{post_id}", method = RequestMethod.DELETE)
	public @ResponseBody void deletePost(@PathVariable("post_id") Long id) {
		postRepository.deleteById(id);
	}

	private Page getPageById(Long id) {
		Page page = null;
		Optional<Page> pageOptional = pageRepository.findById(id);
		
		if(pageOptional.isPresent())
		{
			page = pageOptional.get();
		}
		return page;
	}
}
