package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MainMenu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;	
	private String label;
	@OneToOne
	@JoinColumn(name = "page")
	private Page page;
	
	@OneToMany(targetEntity = SubMenu.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<SubMenu> subMenus;

	public MainMenu() {
		// empty
	}
	
	public MainMenu(String label, Page page) {
		this.label = label;
		this.page = page;
	}
	
	public MainMenu(Long id, String label, Page page) {
		this.id = id;
		this.label = label;
		this.page = page;
	}

	public MainMenu(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
