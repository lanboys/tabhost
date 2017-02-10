package com.m520it.tabhost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.m520it.tabhost.fragmenttabhost.MainActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void fragmentNewTab(View view) {

        Intent intent = new Intent(this, FragmentTabHostActivity.class);
        startActivity(intent);

    }

    public void fragmentNewTab1(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void tabLayoutNewTab(View view) {

        Intent intent = new Intent(this, TabLayoutActivity.class);
        startActivity(intent);

    }public void tabHost(View view) {

        Intent intent = new Intent(this, TabHostActivity.class);
        startActivity(intent);

    }

    public void customTabHost(View view) {

        Intent intent = new Intent(this, CustomTabHostActivity.class);
        startActivity(intent);
    }
}
