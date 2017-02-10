package com.example.zhihu.adapter;

import java.util.List;

import com.example.zhihu.R;
import com.example.zhihu.base.BaseAdapter;
import com.example.zhihu.bean.ThemeItem;
import com.example.zhihu.utils.ImageLoadUtil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeAdapter<T> extends BaseAdapter{

	public HomeAdapter(Context context, List<T> listDates) {
		super(context,listDates);
	}
	
	@Override
	public View getView(int position, View contentView, ViewGroup arg2) {
		ViewHolder viewHolder=null;
		if(contentView==null){
			viewHolder=new ViewHolder();
			contentView=View.inflate(context, R.layout.list_item_home, null);
			viewHolder.imageView= (ImageView)contentView.findViewById(R.id.img_home_item);
			viewHolder.textView= (TextView)contentView.findViewById(R.id.tv_home_item);
			contentView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder)contentView.getTag();
		}
		
		ThemeItem item = (ThemeItem) listDates.get(position);
		if(item!=null){
			viewHolder.textView.setText(item.getTitle());
			List<String> images = item.getImages();
			if(images==null){
				viewHolder.imageView.setVisibility(View.GONE);
			}else{
				viewHolder.imageView.setVisibility(View.VISIBLE);
				ImageLoadUtil.loadImageView(context, viewHolder.imageView, images.get(0));
			
			}
			
		}
		
		return contentView;
	}
	
	static class ViewHolder{
		ImageView imageView;
		TextView textView;
	}
	
	
	

}
