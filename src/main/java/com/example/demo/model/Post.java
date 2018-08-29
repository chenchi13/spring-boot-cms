package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@Lob
	@Column
	private String text;
	@ManyToOne
	@JoinColumn(name = "user", referencedColumnName = "username")
	private User user;
	@ManyToOne
	@JoinColumn(name = "page")
	private Page page;
	
	public Post() {
		// empty
	}
	
	public Post(String title, String text, User user) {
		this.title = title;
		this.text = text;
		this.user = user;
	}
	
	public Post(String title, String text, User user, Page page) {
		this.setTitle(title);
		this.setText(text);
		this.setUser(user);		
		this.setPage(page);
	}

	public Post(Long id, String title, String text, User user, Page page) {
		this.title = title;
		this.text = text;
		this.user = user;
		this.id = id;
		this.page = page;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Long getId() {
		return id;
	}
	
}
