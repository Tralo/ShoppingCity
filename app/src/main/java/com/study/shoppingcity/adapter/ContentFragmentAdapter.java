package com.study.shoppingcity.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.study.shoppingcity.base.BasePager;

import java.util.List;

/**
 * Created by adventurer on 16-11-16.
 */
public class ContentFragmentAdapter extends PagerAdapter {

    private List<BasePager> pagers;

    public ContentFragmentAdapter(List<BasePager> pagers){
        this.pagers = pagers;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BasePager basePager = pagers.get(position);
        View rootView = basePager.rootView;
        container.addView(rootView);

        return rootView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        BasePager basePager = pagers.get(position);
        container.removeView(basePager.rootView);
    }

    @Override
    public int getCount() {
        return pagers.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}