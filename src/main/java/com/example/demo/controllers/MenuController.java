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

import com.example.demo.model.MainMenu;
import com.example.demo.model.Page;
import com.example.demo.repository.*;
import com.example.demo.viewmodels.MenuItemViewModel;

@Controller
public class MenuController {
	
	@Autowired
	private MainMenuRepository mainMenuRepository;
	@Autowired
	private PageRepository pageRepository;
	
	
	@GetMapping("/allMenuItems")
	public String allMenuItems(Model model)
	{
		model.addAttribute("itemModel", new MenuItemViewModel());
		model.addAttribute("items", mainMenuRepository.findAll());
		return "allMenuItems";
	}
	
	@GetMapping("/addNewItem")
	public String addNewMenuItem(Model model)
	{
		model.addAttribute("itemModel", new MenuItemViewModel());
		model.addAttribute("pages", pageRepository.findAll());
		return "addNewItem";
	}
	
	@PostMapping("/addNewItem")
	public String saveNewMenuItem(@ModelAttribute MenuItemViewModel menuItem, Model model)
	{
		mainMenuRepository.save(new MainMenu(menuItem.getLabel(), getPageById(menuItem.getPageId())));
		return "redirect:/allMenuItems";
	}
	
	@GetMapping("/editItem/{item_id}")
	public String editItem(Model model, @PathVariable("item_id") Long id) {
		
		MainMenu itemToEdit = null;
		Optional<MainMenu> itemOptional = mainMenuRepository.findById(id);
		
		if(itemOptional.isPresent())
		{
			itemToEdit = itemOptional.get();
		}
				
		MenuItemViewModel itemViewModel = new MenuItemViewModel();
		itemViewModel.setId(id);
		itemViewModel.setLabel(itemToEdit.getLabel());
		itemViewModel.setPageId(itemToEdit.getPage().getId());
		model.addAttribute("menuItemViewModel", itemViewModel);
		model.addAttribute("pages", pageRepository.findAll());
		
		return "editItem";
	}
	
	@PostMapping("/editItem")
	public String saveEditedItem(@ModelAttribute MenuItemViewModel item, Model model) {
		mainMenuRepository.save(new MainMenu(item.getId(), item.getLabel(), getPageById(item.getPageId())));

		return "redirect:/allMenuItems";
	}
	
	@RequestMapping(value = "/deleteItem/{item_id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteItem(@PathVariable("item_id") Long id) {
		mainMenuRepository.deleteById(id);
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
