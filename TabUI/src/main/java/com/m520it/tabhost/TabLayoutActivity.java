package com.m520it.tabhost;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.m520it.tabhost.fragment.BlankFragment1;
import com.m520it.tabhost.fragment.BlankFragment2;
import com.m520it.tabhost.fragment.BlankFragment3;
import com.m520it.tabhost.fragment.BlankFragment4;
import com.m520it.tabhost.fragment.BlankFragment5;

import java.util.ArrayList;

public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private int[] icon = new int[]{
            R.drawable.zhuti_bar_selector,
            R.drawable.zhuanlan_bar_selector,
            R.drawable.zhuanlan_bar_selector,
            R.drawable.zhuanlan_bar_selector,
            R.drawable.zhuanlan_bar_selector
    };

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        initDatas();

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "Tab: " + (position + 1);
            }
        });

        mTabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        mTabLayout.setupWithViewPager(mViewPager);

        //设置图标
        int tabCount = mTabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            mTabLayout.getTabAt(i).setIcon(icon[i]);
        }
    }

    private void initDatas() {

        mFragments.add(new BlankFragment1());
        mFragments.add(new BlankFragment2());
        mFragments.add(new BlankFragment3());
        mFragments.add(new BlankFragment4());
        mFragments.add(new BlankFragment5());
    }
}
