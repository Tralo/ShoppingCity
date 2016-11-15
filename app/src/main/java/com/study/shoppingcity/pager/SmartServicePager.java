package com.study.shoppingcity.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.study.shoppingcity.base.BasePager;

/**
 * Created by adventurer on 16-11-15.
 */
public class SmartServicePager extends BasePager {


    public SmartServicePager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        tv_title.setText("智慧服务");
        TextView textView = new TextView(context);
        textView.setText("智慧服务内容");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);
        fl_content.addView(textView);
        //绑定数据
    }
}
