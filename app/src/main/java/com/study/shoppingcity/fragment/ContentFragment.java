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
import com.study.shoppingcity.base.BasePager;
import com.study.shoppingcity.pager.GovaffairPager;
import com.study.shoppingcity.pager.HomePager;
import com.study.shoppingcity.pager.NewsCenterPager;
import com.study.shoppingcity.pager.SettingPager;
import com.study.shoppingcity.pager.SmartServicePager;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adventurer on 16-11-14.
 */
public class ContentFragment extends BaseFragment {

    @ViewInject(R.id.viewpager)
    public ViewPager viewPager;
    @ViewInject(R.id.rg_main)
    public RadioGroup rg_main;


    private List<BasePager> pagers = new ArrayList<BasePager>();

    @Override
    protected void initData() {

        //初始化五个页面，并且放入集合中
        pagers.add(new HomePager(getContext()));
        pagers.add(new NewsCenterPager(getContext()));
        pagers.add(new SmartServicePager(getContext()));
        pagers.add(new GovaffairPager(getContext()));
        pagers.add(new SettingPager(getContext()));

        //设置默认选中
        rg_main.check(R.id.rb_home);

    }

    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.content_fragment,null);
        x.view().inject(ContentFragment.this,view);
        return view;
    }
}
