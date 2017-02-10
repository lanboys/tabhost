package com.example.zhihu.bean;

import java.util.List;

public class ThemeItem {

	private String title;
	
	private Integer id;
	
	private Integer type;
	
	private List<String> images;
	

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public ThemeItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThemeItem(String title, Integer id, Integer type) {
		super();
		this.title = title;
		this.id = id;
		this.type = type;
	}

	@Override
	public String toString() {
		return "ThemeItem [title=" + title + ", id=" + id + ", type=" + type
				+ ", images=" + images + "]";
	}

	
	
}
