package com.study.shoppingcity.pager;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.study.shoppingcity.base.BasePager;
import com.study.shoppingcity.domain.NewsCenterPagerBean;
import com.study.shoppingcity.utils.Constants;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by adventurer on 16-11-15.
 */
public class NewsCenterPager extends BasePager {

    private static final  String TAG = "NewsCenterPager";


    public NewsCenterPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        tv_title.setText("新闻中心");
        TextView textView = new TextView(context);
        textView.setText("新闻中心内容");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);
        fl_content.addView(textView);
        //绑定数据

        getDataFromNet();
    }

    private void getDataFromNet() {
        RequestParams params = new RequestParams(Constants.NEW_CENTER_PAGE_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG,"联网成功获取的数据:  " + result);
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.i(TAG,"请求失败: " + ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
        
    }

    private void processData(String json) {
        NewsCenterPagerBean bean = parseJson(json);
        Log.i(TAG,"bean:  " + bean);

    }

    /**
     * 解析json数据
     * @param json
     * @return
     */
    private NewsCenterPagerBean parseJson(String json) {
        return new Gson().fromJson(json,NewsCenterPagerBean.class);
    }


}
