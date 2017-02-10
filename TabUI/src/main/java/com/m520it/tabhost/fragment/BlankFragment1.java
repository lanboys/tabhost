package com.m520it.tabhost.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m520it.tabhost.Constant;
import com.m520it.tabhost.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {

    private View mRootView;

    public BlankFragment1() {
        // Required empty public constructor
    }

    @Override
    public void onDestroy() {
        Log.v(Constant.TAG, "BlankFragment1.onDestroy:::");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.v(Constant.TAG, "BlankFragment1.onDestroyView:::");
        super.onDestroyView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        Log.v(Constant.TAG, "BlankFragment1.onCreateView:::");

        if (mRootView == null) {

            mRootView = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            //需要将view从父容器中移除,否则,mRootView已经挂在到了之前的父容器
            parent.removeView(mRootView);
        }
        return mRootView;
    }
}
