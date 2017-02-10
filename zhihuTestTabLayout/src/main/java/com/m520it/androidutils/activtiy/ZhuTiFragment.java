package com.m520it.androidutils.activtiy;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.m520it.androidutils.R;
import com.m520it.androidutils.adpter.MyBaseAdapter;
import com.m520it.androidutils.bean.DateJson;
import com.m520it.androidutils.utils.RequestUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuTiFragment extends Fragment {
    //    public static final String JSON_URL = "http://news-at.zhihu.com/api/4/news/latest";
    public static final String JSON_URL = "http://news-at.zhihu.com/api/4/theme/11";
    private static final String TAG = "-->520it";
    private ListView mLv;
    private ZhuTiListViewAdapter mAdapter;
    private   ImageView mHeadImage ;

    public ZhuTiFragment() {
        // Required empty public constructor
    }

    private TabLayoutActivity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (TabLayoutActivity) activity;
        mActivity.setHandler(mHandler);
    }
    //试验用
    public Handler mHandler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:

                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zhu_ti, container, false);
        mLv = (ListView) view.findViewById(R.id.zhuti_lv);

        View headView = getActivity().getLayoutInflater().inflate(R.layout.zhuti_head_layout, null);
        mHeadImage = (ImageView) headView.findViewById(R.id.head_iv);
        mLv.addHeaderView(headView);

        mAdapter = new ZhuTiListViewAdapter(getActivity());
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

                DateJson dateJson = DateJson.objectFromData(response);
                //设置listview头图片
                RequestUtil.loadImageByRequest(getActivity(),mHeadImage,dateJson.getImage());
                //设置listview数据
                List<DateJson.StoriesBean> stories = dateJson.getStories();
                mAdapter.setDatas((ArrayList<DateJson.StoriesBean>) stories);


//                Date date = new Gson().fromJson(response, Date.class);
//                List<Stories> stories1 = date.getStories();
//                mAdapter.setDatas((ArrayList<Stories>) stories1);
//                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    }

    class ZhuTiListViewAdapter extends MyBaseAdapter<DateJson.StoriesBean> {
        private static final String TAG = "-->520it";


        public ZhuTiListViewAdapter(Context context) {
            super(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;


            //        if (position != 0) {

            if (convertView == null || convertView.getTag() == null) {

                convertView = LayoutInflater.from(mContext)
                        .inflate(R.layout.zhuti_item_layout, parent, false);

                holder = new ViewHolder();

                holder.newsIconIv = (ImageView) convertView.findViewById(R.id.image_iv);
                holder.titleTv = (TextView) convertView.findViewById(R.id.title_tv);

                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            DateJson.StoriesBean storiesBean = mDatas.get(position);

            String url = storiesBean.getImages().get(0);
            holder.titleTv.setText(storiesBean.getTitle());

            if (url != null) {

                RequestUtil.loadImageByRequest(mContext, holder.newsIconIv, storiesBean.getImages().get(0));
            } else {

                holder.newsIconIv.setVisibility(ImageView.GONE);
            }


            return convertView;
            //        }


            //        convertView = LayoutInflater.from(mContext)
            //                .inflate(R.layout.zhuti_head_layout, parent, false);

            //        return convertView;
        }

        class ViewHolder {
            ImageView newsIconIv;
            TextView titleTv;
            TextView descTv;
        }
    }
}
