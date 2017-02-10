package com.m520it.tabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.m520it.tabhost.fragment.BlankFragment3;
import com.m520it.tabhost.fragment.BlankFragment4;
import com.m520it.tabhost.fragment.BlankFragment5;
import com.m520it.tabhost.fragment.Fragment1;
import com.m520it.tabhost.fragment.Fragment2;

import java.util.ArrayList;
import java.util.List;

public class FragmentTabHostActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;

    private Class fragmentArray[] = {Fragment1.class, Fragment2.class};
    private List<Fragment> mFragmentList;

    private String textViewArray[] = {"首页", "分类"};

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tabhost);
        initTabHost();
        initViewPager();
    }

    private void initTabHost() {
    /*实例化FragmentTabHost对象并进行绑定*/
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);//绑定tahost
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);//此处id到底有什么用,就是为了给mRealtabcontent设置id用的吗

        mTabHost.getTabWidget().setDividerDrawable(null);
        // mTabHost.setScrollIndicators(TabHost.SCROLL_INDICATOR_TOP);//高版本才能使用

        for (int i = 0; i < textViewArray.length; i++) {

            // 给每个Tab按钮设置标签、图标和文字
            FragmentTabHost.TabSpec tabSpec = mTabHost.newTabSpec(textViewArray[i]).setIndicator(textViewArray[i]);

            // 将Tab按钮添加进Tab选项卡中，并绑定Fragment
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
        }
    }

    private void initViewPager() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new BlankFragment3());
        mFragmentList.add(new BlankFragment4());
        mFragmentList.add(new BlankFragment5());

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });
    }
}
