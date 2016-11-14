package com.study.shoppingcity;

import android.app.Application;

import org.xutils.x;

/**
 * Created by adventurer on 16-11-15.
 */
public class NewsApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.setDebug(true);
        x.Ext.init(this);

    }
}
