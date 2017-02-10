package com.example.zhihu;

import com.example.zhihu.comment.APIS;
import com.example.zhihu.fragment.ClassfiyFragment;
import com.example.zhihu.fragment.HomeFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class MainActivity extends ActionBarActivity implements OnCheckedChangeListener {

	private FragmentTransaction beginTransaction;
	private FragmentManager fragmentManager;
	private RadioGroup radioGroup ;
	private HomeFragment homeFragment;
	private ClassfiyFragment classfiyFragment;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
		setListener();
		
    }



	



	private void initView() {
		fragmentManager = getSupportFragmentManager();
		homeFragment=new HomeFragment();
		classfiyFragment=new ClassfiyFragment();
        radioGroup = (RadioGroup) findViewById(R.id.bottom_view);
	}
	
	
	private void setListener() {
		radioGroup.setOnCheckedChangeListener(this);
	}

	private void initDate() {
		replayFragment(homeFragment);
	}
	

    /**
     * 处理RadioGroup的点击事件
     */
	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkId) {
		RadioButton radioButton = (RadioButton)findViewById(checkId);
		switch (checkId) {
		case R.id.rb_home:
			 initDate();
			break;
		case R.id.rb_classfiy:
			 replayFragment(classfiyFragment);
			break;
		default:
			break;
		}
	}

	private void replayFragment(Fragment fragment) {
		beginTransaction = fragmentManager.beginTransaction();
		beginTransaction.replace(R.id.fl_container,fragment);
		beginTransaction.commit();
	}


  
}
