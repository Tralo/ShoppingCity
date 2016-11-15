package com.study.shoppingcity.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.study.shoppingcity.base.BasePager;

/**
 * Created by adventurer on 16-11-15.
 */
public class HomePager extends BasePager {


    public HomePager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        tv_title.setText("主页面");
        TextView textView = new TextView(context);
        textView.setText("主页面内容");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);
        fl_content.addView(textView);
        //绑定数据
    }
}
