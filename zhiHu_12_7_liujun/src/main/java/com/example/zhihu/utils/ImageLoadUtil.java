package com.example.zhihu.utils;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.zhihu.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.widget.ImageView;
/**
 * 加载图片的工具类
 * 
 * @author Administrator
 *
 */
public class ImageLoadUtil {
	private  static  RequestQueue mQueue =null;
	
	public static void loadImageView(Context context,final ImageView imageView, String url) {
		if(mQueue==null)
			mQueue= Volley.newRequestQueue(context); 
	     @SuppressWarnings("deprecation")
		ImageRequest imageRequest = new ImageRequest(  
	    		 url,  
	                new Response.Listener<Bitmap>() {  
	                    @Override  
	                    public void onResponse(Bitmap response) {  
	                        imageView.setImageBitmap(response);  
	                    }  
	                }, 0, 0, Config.RGB_565, new Response.ErrorListener() {  
	                    @Override  
	                    public void onErrorResponse(VolleyError error) {  
	                        imageView.setImageResource(R.drawable.ic_launcher);  
	                    }  
	                });  
	        mQueue.add(imageRequest);
	}

}
