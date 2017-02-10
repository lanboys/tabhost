package com.example.fragmenttest2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button);

		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button:
			Fragment3 fragment3 = new Fragment3();// ?????
			FragmentManager fragmentManager = getFragmentManager();// ???FragmentManager????
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();// ???????
			fragmentTransaction.replace(R.id.frameLayout, fragment3);//???fragment3??????
			fragmentTransaction.addToBackStack(null);//???????
			fragmentTransaction.commit();// ??????
			break;

		default:
			break;
		}
	}

}
