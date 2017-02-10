package com.example.zhihu.fragment;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zhihu.MainActivity;
import com.example.zhihu.R;
import com.example.zhihu.adapter.HomeAdapter;
import com.example.zhihu.bean.ThemeBean;
import com.example.zhihu.bean.ThemeItem;
import com.example.zhihu.comment.APIS;
import com.example.zhihu.utils.ImageLoadUtil;
import com.google.gson.Gson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

public class HomeFragment extends Fragment {
	
	private ListView listView;
	private HomeAdapter<ThemeItem> adapter;
	private RequestQueue mQueue;

	private ThemeBean themeBean=new ThemeBean();
	private List<ThemeItem> stories=new ArrayList<ThemeItem>();
	private ImageView img_header;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getDate(APIS.HOME);
	}
	


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_home, container, false);  
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		listView=(ListView)getActivity().findViewById(R.id.lv_home);
		addHeaderView();
		if(adapter==null){
			adapter=new HomeAdapter<ThemeItem>(getActivity(),stories);
		}
		listView.setAdapter(adapter);
	}

	
	private void addHeaderView() {
		View header = View.inflate(getActivity(), R.layout.list_home_header_view, null);
		img_header=(ImageView)header.findViewById(R.id.img_header);
		listView.addHeaderView(header);
	}
	
	private void getDate(String url) {
		if(mQueue==null)
				mQueue = Volley.newRequestQueue(getActivity());  
		StringRequest stringRequest = new StringRequest(url,  
                new Response.Listener<String>() {  
                    @Override  
                    public void onResponse(String response) {  
                        Log.d("TAG", response);  
                         themeBean = new Gson().fromJson(response, ThemeBean.class);
                         stories=themeBean.getStories();
                         System.out.println("stories="+stories.toString());
                         ImageLoadUtil.loadImageView(getActivity(), img_header, themeBean.getImage());
                         upDateListView();
                    }
                }, new Response.ErrorListener() {  
                    @Override  
                    public void onErrorResponse(VolleyError error) {  
                        Log.e("TAG", error.getMessage(), error);  
                    }  
                });  
		mQueue.add(stringRequest);  
	}
	
	/**
	 * 刷新listView
	 */
	private void upDateListView() {
		adapter.setListDates(stories);
		adapter.notifyDataSetChanged();
	}  

}
