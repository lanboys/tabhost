package com.m520it.androidutils.adpter;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 520 on 2016/12/5.
 */

public abstract class MyBasePagerAdapter extends PagerAdapter {

    private ArrayList<View> mChildViews;
    private Context mContext;

//    private int[] mChildResId;

    public MyBasePagerAdapter(Context context) {
        this.mContext = context;
    }

//    public MyBasePagerAdapter(Context context, int[] mChildResId) {
//        this.mContext = context;
//        this.mChildResId = mChildResId;
//        mChildViews = initChildItem(mChildResId);
//
//    }

    public void setmChildResId(Object object) {
//        this.mChildResId = mChildResId;
        mChildViews = initChildItem(object);
    }

    //重写该方法初始化view
    protected abstract ArrayList<View> initChildItem(Object object);


    //知道整个容器内部有多少个item
    @Override
    public int getCount() {
        return mChildViews == null ? 0 : mChildViews.size();
    }

    //showItems 当前显示的itemView
    //obj 就是instantiateItem 返回的Object对象
    //该方法的意思是: 当前显示对象(showItems)与instantiateItem返回的对象是否是同一个
    @Override
    public boolean isViewFromObject(View showItems, Object childItem) {
        return showItems == childItem;
    }

    //根据position给它一个View  getView  返回View  我们将View的生死交给系统来处理

    //初始化Item每一个子项
    //container 容器==ViewPager
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View childItem = mChildViews.get(position);
        container.addView(childItem);
        return childItem;
    }

    //当它需要销毁掉的时候
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View childItem = mChildViews.get(position);
        container.removeView(childItem);
    }

}
