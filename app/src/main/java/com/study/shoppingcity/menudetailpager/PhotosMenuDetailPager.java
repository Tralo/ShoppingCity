package com.study.shoppingcity.menudetailpager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.study.shoppingcity.base.MenuDetailBasePager;

/**
 * Created by adventurer on 16-11-17.
 */

public class PhotosMenuDetailPager extends MenuDetailBasePager {

    private TextView textView;

    public PhotosMenuDetailPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        textView = new TextView(context);

        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);

        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("图片详情内容");

    }
}
