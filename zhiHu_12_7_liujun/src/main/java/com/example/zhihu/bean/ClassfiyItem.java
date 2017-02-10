package com.example.zhihu.bean;

public class ClassfiyItem {

	private String description;
	
	private Integer id;
	
	private String name;
	
	private String thumbnail;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "ClassfiyItem [description=" + description + ", id=" + id
				+ ", name=" + name + ", thumbnail=" + thumbnail + "]";
	}

	public ClassfiyItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassfiyItem(String description, Integer id, String name,
			String thumbnail) {
		super();
		this.description = description;
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
	}
	
	
	
}
