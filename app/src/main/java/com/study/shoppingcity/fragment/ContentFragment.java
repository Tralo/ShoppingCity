package com.study.shoppingcity.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.study.shoppingcity.base.BaseFragment;

/**
 * Created by adventurer on 16-11-14.
 */
public class ContentFragment extends BaseFragment {
    private TextView tv;

    @Override
    protected void initData() {
        tv.setText("主界面");


    }

    @Override
    public View initView() {
        tv = new TextView(getContext());
        tv.setTextSize(23);
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.RED);
        return tv;
    }
}
