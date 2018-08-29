package com.example.demo.viewmodels;

public class SubmenuItemViewModel {
	private Long id;
	private String label;
	private Long mainMenuId;
	private Long pageId;
	
	public SubmenuItemViewModel(Long id, String label, Long mianMenuId, Long pageId) {
		super();
		this.id = id;
		this.label = label;
		this.mainMenuId = mianMenuId;
		this.pageId = pageId;
	}
	
	public SubmenuItemViewModel() {
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

	public Long getMainMenuId() {
		return mainMenuId;
	}

	public void setMainMenuId(Long mainMenuId) {
		this.mainMenuId = mainMenuId;
	}
	
}
