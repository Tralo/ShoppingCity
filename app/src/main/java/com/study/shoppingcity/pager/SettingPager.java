package com.study.shoppingcity.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.study.shoppingcity.base.BasePager;

/**
 * Created by adventurer on 16-11-15.
 */
public class SettingPager extends BasePager {


    public SettingPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        tv_title.setText("设置");
        TextView textView = new TextView(context);
        textView.setText("设置内容");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);
        fl_content.addView(textView);
        //绑定数据
    }
}
