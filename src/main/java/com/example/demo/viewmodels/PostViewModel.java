package com.example.demo.viewmodels;

public class PostViewModel {
	private Long id;
	private String title;
	private String text;
	private Long pageId;
	
	public PostViewModel(Long pageId) {
		this.pageId = pageId;
	}
	public PostViewModel() {
		// empty
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPageId() {
		return pageId;
	}
	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}
	
}
