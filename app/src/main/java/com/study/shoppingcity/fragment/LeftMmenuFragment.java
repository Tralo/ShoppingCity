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
import android.widget.TextView;

import com.study.shoppingcity.base.BaseFragment;
import com.study.shoppingcity.domain.NewsCenterPagerBean;

import java.util.List;

/**
 * Created by adventurer on 16-11-14.
 */
public class LeftMmenuFragment extends BaseFragment {

    private static final String TAG = "LeftMmenuFragment";

    private TextView tv;

    private List<NewsCenterPagerBean.DataBean> data;

    @Override
    protected void initData() {
        tv.setText("左侧菜单");


    }

    @Override
    public View initView() {
        tv = new TextView(getContext());
        tv.setTextSize(23);
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.RED);
        return tv;
    }

    public void setData(List<NewsCenterPagerBean.DataBean> data) {
        this.data = data;
        for(NewsCenterPagerBean.DataBean bean : data){
            Log.i(TAG, "title   ==   " + bean.getTitle());
        }
    }
}
