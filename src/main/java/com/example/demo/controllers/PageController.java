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
import com.example.demo.repository.PageRepository;
import com.example.demo.viewmodels.PageViewModel;

@Controller
public class PageController {
	@Autowired
	PageRepository pageRepository;
	
	@GetMapping("/allPages")
	public String allPages(Model model)
	{
		model.addAttribute("pageModel", new PageViewModel());
		model.addAttribute("pages", pageRepository.findAll());
		return "allPages";
	}
	
	@GetMapping("/addNewPage")
	public String addNewPage(Model model)
	{
		model.addAttribute("pageModel", new PageViewModel());
		
		return "addNewPage";
	}
	
	@PostMapping("/addNewPage")
	public String saveNewPage(@ModelAttribute PageViewModel page, Model model)
	{
		pageRepository.save(new Page(page.getTitle(), page.getSubtitle()));
		return "redirect:/allPages";
	}
	
	@GetMapping("/editPage/{page_id}")
	public String editPage(Model model, @PathVariable("page_id") Long id) {
		
		Page pageToEdit = null;
		Optional<Page> pageOptional = pageRepository.findById(id);
		
		if(pageOptional.isPresent())
		{
			pageToEdit = pageOptional.get();
		}
				
		PageViewModel pageViewModel = new PageViewModel();
		pageViewModel.setId(id);
		pageViewModel.setTitle(pageToEdit.getTitle());
		pageViewModel.setSubtitle(pageToEdit.getSubtitle());
		model.addAttribute("pageViewModel", pageViewModel);
		
		return "editPage";
	}

	@PostMapping("/editPage")
	public String saveEditedPage(@ModelAttribute PageViewModel page, Model model) {
		
		
		pageRepository.save(new Page(page.getId(), page.getTitle(), page.getSubtitle()));

		return "redirect:/allPages";
	}
	
	@RequestMapping(value = "/deletePage/{page_id}", method = RequestMethod.DELETE)
	public @ResponseBody void deletePage(@PathVariable("page_id") Long id) {
		pageRepository.deleteById(id);
	}
}
