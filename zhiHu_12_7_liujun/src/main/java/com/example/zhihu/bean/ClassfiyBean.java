package com.example.zhihu.bean;

import java.util.List;

public class ClassfiyBean {

	private List<ClassfiyItem> data;

	public List<ClassfiyItem> getData() {
		return data;
	}

	public void setData(List<ClassfiyItem> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ClassfiyBean [data=" + data + "]";
	}

	public ClassfiyBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassfiyBean(List<ClassfiyItem> data) {
		super();
		this.data = data;
	}
	
	
}
