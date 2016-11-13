package com.study.shoppingcity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.study.shoppingcity.activity.GuideActivity;
import com.study.shoppingcity.utils.CacheUtils;

public class SplashActivity extends AppCompatActivity {

    private static final String START_MAIN = "start_main";

    private RelativeLayout rl_splash;

    //渐变动画，缩放动画，旋转动画
    private AlphaAnimation aa;
    private ScaleAnimation sa;
    private RotateAnimation ra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initAnimation();

    }

    private void initView() {
        rl_splash = (RelativeLayout) findViewById(R.id.rl_splash);

    }

    private void initAnimation() {
        aa = new AlphaAnimation(0,1);
        aa.setDuration(3000);
        aa.setFillAfter(true);

        sa = new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(3000);
        sa.setFillAfter(true);

        ra = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(3000);
        ra.setFillAfter(true);

        AnimationSet set =  new AnimationSet(false);
        //添加三个动画没有先后顺序
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.addAnimation(ra);
        rl_splash.startAnimation(set);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //判断是否进入过主页面
                boolean isStartMain = CacheUtils.getBoolean(SplashActivity.this,START_MAIN);


                if(isStartMain){
                    //如果进入过主页面，直接进入主页面
                } else {
                    //如果没有进入过主页面，进入引导页面
                    Intent i = new Intent(SplashActivity.this,GuideActivity.class);
                    startActivity(i);

                }

                finish();


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });



    }
}
