package com.m520it.tabhost.fragmenttabhost;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.m520it.tabhost.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;
    private ViewPager mViewPager;
    private List<Fragment> mFragmentList;
    private Class mClass[] = {HomeFragment.class, ReportFragment.class, MessageFragment.class, MineFragment.class};
    private Fragment mFragment[] = {new HomeFragment(), new ReportFragment(), new MessageFragment(), new MineFragment()};
    private String mTitles[] = {"首页", "报表", "消息", "我的"};
    private int mImages[] = {
            R.drawable.tab_home,
            R.drawable.tab_report,
            R.drawable.tab_message,
            R.drawable.tab_mine
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        initView();
        // initEvent();
    }

    private void initView() {
        initTab();
        // initViewPager();
    }

    private void initTab() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < mFragment.length; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTitles[i]).setIndicator(getTabView(i));
            mTabHost.addTab(tabSpec, mClass[i], null);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE);
        }
    }

    private void initViewPager() {
        mFragmentList = new ArrayList<>();
        for (Fragment aMFragment : mFragment) {
            mFragmentList.add(aMFragment);
        }
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

    private View getTabView(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item, null);

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView title = (TextView) view.findViewById(R.id.title);

        image.setImageResource(mImages[index]);
        title.setText(mTitles[index]);

        return view;
    }

    private void initEvent() {

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                mViewPager.setCurrentItem(mTabHost.getCurrentTab());
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
