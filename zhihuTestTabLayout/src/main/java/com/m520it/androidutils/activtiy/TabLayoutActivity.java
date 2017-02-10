package com.m520it.androidutils.activtiy;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.m520it.androidutils.R;


public class TabLayoutActivity extends AppCompatActivity {

    private static final String TAG = "-->520it";
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    //    private int mTabCount = 2;

    private Fragment[] fragments = new Fragment[]{new ZhuTiFragment(), new ZhuanLanFragment()};
    private String[] title = new String[]{"主题", "专栏"};
    private int[] icon = new int[]{R.drawable.zhuti_bar_selector, R.drawable.zhuanlan_bar_selector};
    private Handler mHandler;

    public void setHandler(Handler handler) {
        mHandler = handler;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });

        mTabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        //此处跟viewPager建立关联
        mTabLayout.setupWithViewPager(mViewPager);
        //设置图标
        int tabCount = mTabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            mTabLayout.getTabAt(i).setIcon(icon[i]);
        }
    }
}
