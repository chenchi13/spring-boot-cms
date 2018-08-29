package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SubMenu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String label;
	@ManyToOne
	@JoinColumn(name = "main_menu", referencedColumnName = "label")
	private MainMenu mainMenu;
	@OneToOne
	@JoinColumn(name = "page")
	private Page page;
	
	public SubMenu() {
		// empty
	}
	
	public SubMenu(String label, MainMenu mainMenu, Page page) {
		this.label = label;
		this.mainMenu = mainMenu;
		this.page = page;
	}
	
	public SubMenu(Long id, String label, MainMenu mainMenu, Page page) {
		this.id = id;
		this.label = label;
		this.mainMenu = mainMenu;
		this.page = page;
	}
	
	public SubMenu(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
