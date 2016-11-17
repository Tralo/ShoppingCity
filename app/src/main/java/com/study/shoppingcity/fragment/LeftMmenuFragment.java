package com.study.shoppingcity.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.study.shoppingcity.R;
import com.study.shoppingcity.activity.MainActivity;
import com.study.shoppingcity.base.BaseFragment;
import com.study.shoppingcity.domain.NewsCenterPagerBean;
import com.study.shoppingcity.utils.DensityUtil;

import java.util.List;

/**
 * Created by adventurer on 16-11-14.
 */
public class LeftMmenuFragment extends BaseFragment {

    private static final String TAG = "LeftMmenuFragment";

    private ListView lv;

    private List<NewsCenterPagerBean.DataBean> data;

    private LeftMenuFragmentAdapter adapter;

    private int curPosition = 0;

    @Override
    protected void initData() {

    }

    @Override
    public View initView() {
        lv = new ListView(getContext());
        lv.setPadding(0, DensityUtil.dip2px(getContext(),40),0,0);
        lv.setDividerHeight(0);
        lv.setCacheColorHint(Color.TRANSPARENT);
        //设置按下listView的item不变色
        lv.setSelector(android.R.color.transparent);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                curPosition = i;
                adapter.notifyDataSetChanged();
                MainActivity ma = (MainActivity) getActivity();
                ma.getSlidingMenu().toggle();

            }
        });
        return lv;
    }

    public void setData(List<NewsCenterPagerBean.DataBean> data) {
        this.data = data;
        for(NewsCenterPagerBean.DataBean bean : data){
            Log.i(TAG, "title   ==   " + bean.getTitle());
        }
        adapter = new LeftMenuFragmentAdapter();
        lv.setAdapter(adapter);


    }
    class LeftMenuFragmentAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = View.inflate(getContext(), R.layout.item_leftmenu,null);
            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_title.setText(data.get(i).getTitle());

            tv_title.setEnabled(curPosition == i);
            return view;
        }
    }
}
