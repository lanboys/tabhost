package com.m520it.androidutils.activtiy;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.m520it.androidutils.R;
import com.m520it.androidutils.adpter.MyBaseAdapter;
import com.m520it.androidutils.bean.DatasJson;
import com.m520it.androidutils.utils.RequestUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhy on 16/6/6.
 */
public class ZhuanLanFragment extends Fragment {

    //    public static final String JSON_URL = "http://news-at.zhihu.com/api/4/news/latest";
    public static final String JSON_URL = "http://news-at.zhihu.com/api/3/sections";
    private static final String TAG = "-->520it";
    private GridView mLv;
    private ZhuanLanListViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zhuan_lan, container, false);
        mLv = (GridView) view.findViewById(R.id.zhuanlan_lv);

//                View headView = getActivity().getLayoutInflater().inflate(R.layout.zhuti_head_layout, null);
//                mLv.addHeaderView(headView);

        mAdapter = new ZhuanLanListViewAdapter(getActivity());
        mLv.setAdapter(mAdapter);
        mLv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //parent == mLv
                //                Log.v(TAG, "Main2Activity.onItemLongClick():48:: " + parent.getAdapter().getItem(position));

                return false;
            }
        });
        initDatas();
        return view;
    }

    private void initDatas() {

        RequestUtil.loadStringByRequest(getActivity(), JSON_URL, new RequestUtil.CallBackListner<String>() {
            @Override
            public void OnFinish(String response) {

                DatasJson datasJson = DatasJson.objectFromData(response);
                List<DatasJson.DataBean> data = datasJson.getData();

                mAdapter.setDatas((ArrayList<DatasJson.DataBean>) data);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    }

     class ZhuanLanListViewAdapter extends MyBaseAdapter<DatasJson.DataBean> {
        private static final String TAG = "-->520it";


        public ZhuanLanListViewAdapter(Context context) {
            super(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null ) {
                convertView = LayoutInflater.from(mContext)
                        .inflate(R.layout.zhuanlan_item_layout, parent, false);
                holder = new  ViewHolder();
                holder.newsIconIv = (ImageView) convertView.findViewById(R.id.image_zl_iv);
                WindowManager manager = ((Activity)mContext).getWindowManager();

                Display display = manager.getDefaultDisplay();//获取屏幕的显示信息
                int screenWidth = display.getWidth();
                int screenHeight = display.getHeight();

                holder.newsIconIv.setLayoutParams(new LinearLayout.LayoutParams(screenWidth/2-10,screenWidth/2-10));

                holder.titleTv = (TextView) convertView.findViewById(R.id.title_zl_tv);
                holder.descTv = (TextView) convertView.findViewById(R.id.desc_zl_tv);
                convertView.setTag(holder);
            } else {
                holder = ( ViewHolder) convertView.getTag();
            }

            DatasJson.DataBean dataBean = mDatas.get(position);

            RequestUtil.loadImageByRequest(mContext, holder.newsIconIv, dataBean.getThumbnail());

            holder.titleTv.setText(dataBean.getName());

            holder.descTv.setText(dataBean.getDescription());

            return convertView;
        }

        class ViewHolder {
            ImageView newsIconIv;
            TextView titleTv;
            TextView descTv;
        }
    }

}
