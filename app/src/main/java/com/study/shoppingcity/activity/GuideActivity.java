package com.study.shoppingcity.activity;

import android.content.Intent;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.study.shoppingcity.R;
import com.study.shoppingcity.SplashActivity;
import com.study.shoppingcity.utils.CacheUtils;
import com.study.shoppingcity.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private Button btn_start;
    private ViewPager viewPager;
    private LinearLayout ll_point_group;
    private ImageView iv_red;
    private int[] ids ={
            R.mipmap.guide_1,
            R.mipmap.guide_2,
            R.mipmap.guide_3
    };
    //两点的间距
    private int leftmax = 0;

    private int currPos = 0;


    private List<ImageView> imageViews = new ArrayList<ImageView>();

    private List<ImageView> dotViews = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initDotGroup();
        initGuideViews();
        initViewPager();
        initListener();
    }

    private void initListener() {
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.保存记录参数
                CacheUtils.setBoolean(GuideActivity.this, SplashActivity.START_MAIN,true);
                Intent i = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void initDotGroup() {
        for(int i = 0; i < ids.length; i++){
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_normal);
            dotViews.add(point);
            /**
             * 单位是像素
             */
            LinearLayout.LayoutParams params
                    = new LinearLayout.LayoutParams(DensityUtil.dip2px(GuideActivity.this,10)
                    ,DensityUtil.dip2px(GuideActivity.this,10));
            if(i != 0){
                params.leftMargin =  DensityUtil.dip2px(GuideActivity.this,10);
            }


            point.setLayoutParams(params);
            //添加到线性布里面
            ll_point_group.addView(point);

        }
    }

    //设置viewpager的适配器,监听事件
    private void initViewPager() {
        viewPager.setAdapter(new GuidePagerAdapter());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               /* Log.i("GuideActivity","currPos: " + currPos +"    position:"+ position+"   positionOffset: " + positionOffset + "     positionOffsetPixels: " + positionOffsetPixels);
                if(currPos > position){

                }
                if(currPos < position){

                }*/
                int leftmargin = (int) (position * leftmax + positionOffset * leftmax);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv_red.getLayoutParams();
                params.leftMargin = leftmargin;
                iv_red.setLayoutParams(params);


            }

            @Override
            public void onPageSelected(int position) {
                currPos = position;
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

        //根据View的生命周期，当视图执行到onLayout或者onDraw的时候，视图的高和宽，边距都有类
        iv_red.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());


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
        iv_red = (ImageView) findViewById(R.id.iv_red);
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

    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener{

        @Override
        public void onGlobalLayout() {
            //执行不止一次
            iv_red.getViewTreeObserver().removeGlobalOnLayoutListener(this);

            leftmax = ll_point_group.getChildAt(1).getLeft() - ll_point_group.getChildAt(0).getLeft();

        }
    }


}
