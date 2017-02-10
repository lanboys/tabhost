package com.m520it.androidutils.adpter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by 520 on 2016/12/5.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    protected ArrayList<T> mDatas;
    protected Context mContext;

    public MyBaseAdapter(Context context) {
        this(context, null);
    }

    public MyBaseAdapter(Context context, ArrayList<T> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    public ArrayList<T> getDatas() {
        return mDatas;
    }

    public void setDatas(ArrayList<T> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //    class ViewHolder{
    //        ImageView newsIconIv;
    //        TextView titleTv;
    //        TextView descTv;
    //    }
    //
    //    @Override
    //    public View getView(int position, View convertView, ViewGroup parent) {
    //        ViewHolder holder=null;
    //        if (convertView==null) {
    //            //Context  每个控件都自带了context
    //            convertView= LayoutInflater.from(parent.getContext())
    //                    .inflate(R.layout.news_item_layout, parent, false);
    //            holder=new ViewHolder();
    //            //6.对holder对象内部所有子控件进行初始化
    //            holder.newsIconIv=(ImageView) convertView.findViewById(R.id.news_icon_iv);
    //            holder.titleTv=(TextView) convertView.findViewById(R.id.title_tv);
    //            holder.descTv=(TextView) convertView.findViewById(R.id.description_tv);
    //
    //            //7.当convertView有了之后 需要将holer对象缓存起来
    //            convertView.setTag(holder);
    //        }else {
    //            holder=(ViewHolder) convertView.getTag();
    //        }
    //
    //        NewsBean bean = mDatas.get(position);
    //        holder.newsIconIv.setImageResource(bean.getResImageId());
    //        holder.titleTv.setText(bean.getTitle());
    //        holder.descTv.setText(bean.getDescription());
    //        return convertView;
    //    }
}
