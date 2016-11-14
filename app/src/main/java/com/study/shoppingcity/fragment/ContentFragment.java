package com.study.shoppingcity.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.study.shoppingcity.R;
import com.study.shoppingcity.base.BaseFragment;

/**
 * Created by adventurer on 16-11-14.
 */
public class ContentFragment extends BaseFragment {

    private ViewPager viewPager;
    private RadioGroup rg_main;

    @Override
    protected void initData() {
        //设置默认选中
        rg_main.check(R.id.rb_home);

    }

    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.content_fragment,null);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        rg_main = (RadioGroup) view.findViewById(R.id.rg_main);
        return view;
    }
}
