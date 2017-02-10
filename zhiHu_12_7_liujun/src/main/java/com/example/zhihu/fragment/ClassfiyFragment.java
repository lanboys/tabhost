package com.example.zhihu.fragment;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zhihu.R;
import com.example.zhihu.adapter.ClassfiyAdapter;
import com.example.zhihu.adapter.HomeAdapter;
import com.example.zhihu.bean.ClassfiyBean;
import com.example.zhihu.bean.ClassfiyItem;
import com.example.zhihu.comment.APIS;
import com.google.gson.Gson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

public class ClassfiyFragment extends Fragment {
	
	private GridView gridView;
	private ClassfiyAdapter adapter;
	private RequestQueue mQueue;
	private List<ClassfiyItem> data=new ArrayList<ClassfiyItem>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getDate(APIS.CLASSIFY);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_classfiy, container, false);  
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		gridView=(GridView)getActivity().findViewById(R.id.lv_classfiy);
		if(adapter==null){
			adapter=new ClassfiyAdapter<ClassfiyItem>(getActivity(),data);
		}
		gridView.setAdapter(adapter);
		
	}
	
	
	private void getDate(String url) {
		if(mQueue==null)
				mQueue = Volley.newRequestQueue(getActivity());  
		StringRequest stringRequest = new StringRequest(url,  
                new Response.Listener<String>() {  
                    @Override  
                    public void onResponse(String response) {  
                        Log.d("TAG", response);  
                         ClassfiyBean classfiyBean = new Gson().fromJson(response, ClassfiyBean.class);
                         data=classfiyBean.getData();
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
	
	private void upDateListView() {
		adapter.setListDates(data);
		adapter.notifyDataSetChanged();
		
	}  

}
