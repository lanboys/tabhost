package com.m520it.tabhost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;

import com.m520it.tabhost.fragmenttabhost.MainActivity;

public class TabHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);

        newTabHost();
    }

    //用  android.widget.TabHost  创建tab界面
    public void newTabHost() {
        //默认的TabHost
        TabHost tabHost=(TabHost)findViewById(android.R.id.tabhost);
        //初始化TabHost容器,通过 findViewById 找 mTabWidget, mTabContent 这两个标签,所以布局文件必须有
        tabHost.setup();
        //在TabHost创建标签，然后设置：标题／图标／标签页布局
        //setContent的内容必须是在tabContent中,内容可以是fragment,view e.g.
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("标签1", null).setContent(R.id.tab1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("标签2",null).setContent(R.id.tab2));
    }






}
