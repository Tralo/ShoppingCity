package com.study.shoppingcity.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.study.shoppingcity.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private Button btn_start;
    private ViewPager viewPager;
    private LinearLayout ll_point_group;
    private int[] ids ={
            R.mipmap.guide_1,
            R.mipmap.guide_2,
            R.mipmap.guide_3
    };

    private List<ImageView> imageViews = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initGuideViews();
        initViewPager();
    }
    //设置viewpager的适配器,监听事件
    private void initViewPager() {
        viewPager.setAdapter(new GuidePagerAdapter());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if(position == (ids.length -1 )){
                    btn_start.setVisibility(View.VISIBLE);
                } else {
                    btn_start.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initGuideViews() {
        for(int i = 0; i < ids.length; i++){
            ImageView iv = new ImageView(this);
            iv.setBackgroundResource(ids[i]);
            imageViews.add(iv);
        }
    }

    private void initView() {
        btn_start = (Button) findViewById(R.id.btn_start);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ll_point_group = (LinearLayout) findViewById(R.id.ll_point_group);
    }


    class GuidePagerAdapter extends PagerAdapter{

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));

            return imageViews.get(position);
        }

        @Override
        public int getCount() {
            return ids.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }


}
