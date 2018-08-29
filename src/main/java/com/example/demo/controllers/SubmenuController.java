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
import com.example.demo.model.SubMenu;
import com.example.demo.repository.MainMenuRepository;
import com.example.demo.repository.PageRepository;
import com.example.demo.repository.SubMenuRepository;
import com.example.demo.viewmodels.SubmenuItemViewModel;

@Controller
public class SubmenuController {

	@Autowired
	private SubMenuRepository subMenuRepository;
	@Autowired
	private PageRepository pageRepository;
	@Autowired
	private MainMenuRepository mainMenuRepository;
	
	
	@GetMapping("/allSubmenuItems")
	public String allSubmenuItems(Model model)
	{
		model.addAttribute("itemModel", new SubmenuItemViewModel());
		model.addAttribute("items", subMenuRepository.findAll());
		return "allSubmenuItems";
	}
	
	@GetMapping("/addNewSubItem")
	public String addNewMenuItem(Model model)
	{
		model.addAttribute("itemModel", new SubmenuItemViewModel());
		model.addAttribute("mainmenus", mainMenuRepository.findAll());
		model.addAttribute("pages", pageRepository.findAll());
		return "addNewSubItem";
	}
	
	@PostMapping("/addNewSubItem")
	public String saveNewMenuItem(@ModelAttribute SubmenuItemViewModel menuItem, Model model)
	{
		subMenuRepository.save(new SubMenu(menuItem.getLabel(), getMainMenuById(menuItem.getMainMenuId()),getPageById(menuItem.getPageId())));
		return "redirect:/allSubmenuItems";
	}
	
	@GetMapping("/editSubItem/{item_id}")
	public String editItem(Model model, @PathVariable("item_id") Long id) {
		
		SubMenu itemToEdit = null;
		Optional<SubMenu> itemOptional = subMenuRepository.findById(id);
		
		if(itemOptional.isPresent())
		{
			itemToEdit = itemOptional.get();
		}
				
		SubmenuItemViewModel itemViewModel = new SubmenuItemViewModel();
		itemViewModel.setId(id);
		itemViewModel.setLabel(itemToEdit.getLabel());
		itemViewModel.setMainMenuId(itemToEdit.getMainMenu().getId());
		itemViewModel.setPageId(itemToEdit.getPage().getId());
		model.addAttribute("submenuItemViewModel", itemViewModel);
		model.addAttribute("mainmenus", mainMenuRepository.findAll());
		model.addAttribute("pages", pageRepository.findAll());
		
		return "editSubItem";
	}
	
	@PostMapping("/editSubItem")
	public String saveEditedItem(@ModelAttribute SubmenuItemViewModel item, Model model) {
		subMenuRepository.save(new SubMenu(item.getId(), item.getLabel(), getMainMenuById(item.getMainMenuId()), getPageById(item.getPageId())));

		return "redirect:/allSubmenuItems";
	}
	
	@RequestMapping(value = "/deleteSubItem/{item_id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteItem(@PathVariable("item_id") Long id) {
		subMenuRepository.deleteById(id);
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
	
	private MainMenu getMainMenuById(Long id) {
		MainMenu item = null;
		
		Optional<MainMenu> itemOptional = mainMenuRepository.findById(id);
		
		if(itemOptional.isPresent())
		{
			item = itemOptional.get();
		}
		
		return item;
	}
	
}
