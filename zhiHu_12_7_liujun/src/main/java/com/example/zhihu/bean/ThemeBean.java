package com.example.zhihu.bean;

import java.util.List;

public class ThemeBean {

	private String description;
	
	private String background;
	
	private String image;
	
	private List<ThemeItem> stories;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<ThemeItem> getStories() {
		return stories;
	}

	public void setStories(List<ThemeItem> stories) {
		this.stories = stories;
	}

	public ThemeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThemeBean(String description, String background, String image,
			List<ThemeItem> stories) {
		super();
		this.description = description;
		this.background = background;
		this.image = image;
		this.stories = stories;
	}

	@Override
	public String toString() {
		return "ThemeBean [description=" + description + ", background="
				+ background + ", image=" + image + ", stories=" + stories
				+ "]";
	}
	
	
}
