package com.study.shoppingcity.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by adventurer on 16-11-13.
 */
public class CacheUtils {
    /**
     * 得到缓存值
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }
}
