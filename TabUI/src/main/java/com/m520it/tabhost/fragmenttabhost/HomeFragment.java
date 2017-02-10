package com.m520it.tabhost.fragmenttabhost;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m520it.tabhost.R;

/**
 * Created by donglinghao on 2016-01-28.
 */
public class HomeFragment extends Fragment {

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null){
            Log.e("666","HomeFragment");
            mRootView = inflater.inflate(R.layout.home_fragment,container,false);
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null){
            //需要将view从父容器中移除,否则,mRootView已经挂在到了之前的父容器
            parent.removeView(mRootView);
        }
        return mRootView;
    }
}
