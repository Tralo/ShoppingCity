package com.study.shoppingcity.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.study.shoppingcity.R;
import com.study.shoppingcity.fragment.ContentFragment;
import com.study.shoppingcity.fragment.LeftMmenuFragment;
import com.study.shoppingcity.utils.DensityUtil;

import org.xutils.x;

public class MainActivity extends SlidingFragmentActivity {

    private static final String MAIN_CONTENT_TAG = "main_content_tag";
    private static final String LEFTMENU_TAG = "leftmenu_tag";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.设置主页面
        setContentView(R.layout.activity_main);
        initSlideMenu();
        initFragment();
    }

    private void initFragment() {
        //1.得到FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction ft = fm.beginTransaction();
        //3.替换
        ft.replace(R.id.fl_main_content,new ContentFragment(),MAIN_CONTENT_TAG);
        ft.replace(R.id.fl_leftmenu,new LeftMmenuFragment(),LEFTMENU_TAG);
        //4.提交
        ft.commit();
    }

    private void initSlideMenu() {
        //2.设置左侧菜单
        setBehindContentView(R.layout.activity_leftmenu);

        //3.设置右侧菜单
        SlidingMenu slidingMenu = getSlidingMenu();
//        slidingMenu.setSecondaryMenu(R.layout.activit_rightmenu);

        //4.设置模式:左侧菜单+ 主页， 左侧菜单+主页+右侧菜单，主页+右侧菜单
        slidingMenu.setMode(SlidingMenu.LEFT);
        //5.设置滑动模式:滑动边缘，全屏滑动，不可以滑动

        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        //6.设置主页占据的宽度
        slidingMenu.setBehindOffset(DensityUtil.dip2px(MainActivity.this,200));
    }

    public LeftMmenuFragment getLeftMenuFragment() {
        return (LeftMmenuFragment) getSupportFragmentManager().findFragmentByTag(LEFTMENU_TAG);
    }
}
