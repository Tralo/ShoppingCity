package com.study.shoppingcity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {

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

    }
}
