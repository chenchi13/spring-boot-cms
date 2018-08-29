package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;	
	private String title;
	private String subtitle;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(targetEntity = Post.class, cascade = CascadeType.ALL)
	private List<Post> posts;
	
	public Page() {
		// empty
	}
	
	public Page(String title, String subtitle) {
		this.title = title;
		this.subtitle = subtitle;
	}
	
	public Page(Long id, String title, String subtitle) {
		this.id = id;
		this.title = title;
		this.subtitle = subtitle;
	}
	
	public Page(String title, String subtitle, List<Post> posts) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.posts = posts;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
