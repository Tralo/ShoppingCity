package com.study.shoppingcity.base;

import android.content.Context;
import android.view.View;

/**
 * Created by adventurer on 16-11-17.
 */

public abstract class MenuDetailBasePager {

    protected Context context;

    protected View rootView;

    public MenuDetailBasePager(Context context){
        this.context = context;
        rootView = initView();
        initData();
    }

    public abstract View initView();

    public void initData(){

    }

}
