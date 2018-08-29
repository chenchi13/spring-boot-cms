package com.example.demo.viewmodels;

public class MenuItemViewModel {
	private Long id;
	private String label;
	private Long pageId;
	
	public MenuItemViewModel(Long id, String label, Long pageId) {
		super();
		this.id = id;
		this.label = label;
		this.pageId = pageId;
	}
	
	public MenuItemViewModel() {
		// empty
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Long getPageId() {
		return pageId;
	}
	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}
}
