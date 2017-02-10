package com.example.zhihu.adapter;

import java.util.List;

import com.example.zhihu.R;
import com.example.zhihu.base.BaseAdapter;
import com.example.zhihu.bean.ClassfiyItem;
import com.example.zhihu.utils.ImageLoadUtil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassfiyAdapter<T> extends BaseAdapter{

	public ClassfiyAdapter(Context context, List<T> listDates) {
		super(context,listDates);
	}
	
	@Override
	public View getView(int position, View contentView, ViewGroup arg2) {
		ViewHolder viewHolder=null;
		if(contentView==null){
			viewHolder=new ViewHolder();
			contentView=View.inflate(context, R.layout.list_item_classfiy, null);
			viewHolder.imageView=(ImageView) contentView.findViewById(R.id.img_classfiy_item);
			viewHolder.title=(TextView) contentView.findViewById(R.id.tv_classfiy_item_title);
			viewHolder.description=(TextView) contentView.findViewById(R.id.tv_classfiy_item_description);
			contentView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) contentView.getTag();
		}
		ClassfiyItem item = (ClassfiyItem) listDates.get(position);
		if(item!=null){
			ImageLoadUtil.loadImageView(context, viewHolder.imageView, item.getThumbnail());
			viewHolder.title.setText(item.getName());
			viewHolder.description.setText(item.getDescription());
		}
		return contentView;
	}
	
	static class ViewHolder{
	 ImageView imageView;
	 TextView title;
	 TextView description;
	}
	
	
	

}
