package com.study.shoppingcity.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.shoppingcity.R;

/**
 * Created by adventurer on 16-11-15.
 */
public class BasePager {

    /**
     * 上下文
     */
    protected final Context context;//MainActivity

    public View rootView;

    protected TextView tv_title;
    protected ImageView ib_menu;
    private FrameLayout fl_content;


    public BasePager(Context context){
        this.context = context;
        rootView = initView();
        initData();
    }

    private void initData() {

    }

    private View initView() {
        View view = View.inflate(context, R.layout.base_pager,null);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        fl_content = (FrameLayout) view.findViewById(R.id.fl_content);
        ib_menu = (ImageView) view.findViewById(R.id.ib_menu);

        return view;

    }


}
