package com.study.shoppingcity.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.study.shoppingcity.R;
import com.study.shoppingcity.activity.MainActivity;
import com.study.shoppingcity.adapter.ContentFragmentAdapter;
import com.study.shoppingcity.base.BaseFragment;
import com.study.shoppingcity.base.BasePager;
import com.study.shoppingcity.pager.GovaffairPager;
import com.study.shoppingcity.pager.HomePager;
import com.study.shoppingcity.pager.NewsCenterPager;
import com.study.shoppingcity.pager.SettingPager;
import com.study.shoppingcity.pager.SmartServicePager;
import com.study.shoppingcity.view.NoScrollViewPager;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adventurer on 16-11-14.
 */
public class ContentFragment extends BaseFragment {

    @ViewInject(R.id.viewpager)
    public NoScrollViewPager viewPager;
    @ViewInject(R.id.rg_main)
    public RadioGroup rg_main;

    private int[] rbIds = {R.id.rb_home,R.id.rb_newscenter,R.id.rb_smartservice,R.id.rb_govaffair,R.id.rb_setting};


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

        pagers.get(0).initData();

        isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);

        //设置ViewPager的适配器

        viewPager.setAdapter(new ContentFragmentAdapter(pagers));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg_main.check(rbIds[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                switch (i){
                    case R.id.rb_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_newscenter:
                        viewPager.setCurrentItem(1);
                        isEnableSlidingMenu(SlidingMenu.TOUCHMODE_FULLSCREEN);
                        break;
                    case R.id.rb_smartservice:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb_govaffair:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.rb_setting:
                        viewPager.setCurrentItem(4);
                        break;
                }

            }
        });
    }

    private void isEnableSlidingMenu(int touchmodeFullscreen) {
        MainActivity activity = (MainActivity) getContext();
        activity.getSlidingMenu().setTouchModeAbove(touchmodeFullscreen);
    }

    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.content_fragment,null);
        x.view().inject(ContentFragment.this,view);
        return view;
    }


}
