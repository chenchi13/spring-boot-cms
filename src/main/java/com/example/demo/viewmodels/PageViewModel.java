package com.example.demo.viewmodels;

public class PageViewModel {
	private Long id;
	private String title;
	private String subtitle;
	
	public PageViewModel(String title, String subtitle) {
		super();
		this.title = title;
		this.subtitle = subtitle;
	}

	public PageViewModel() {
		// empty
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
}
