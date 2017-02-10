package com.example.zhihu.base;


import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class BaseAdapter<T> extends android.widget.BaseAdapter{

	
	protected Context context;
	protected List<T> listDates;
	
	
	public BaseAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseAdapter(Context context, List<T> listDates) {
		super();
		this.context = context;
		this.listDates = listDates;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public java.util.List<T> getListDates() {
		return listDates;
	}

	public void setListDates(java.util.List<T> listDates) {
		this.listDates = listDates;
	}

	@Override
	public int getCount() {
		return listDates==null?0:listDates.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	



}
