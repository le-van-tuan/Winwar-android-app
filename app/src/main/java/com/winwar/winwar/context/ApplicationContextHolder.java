package com.winwar.winwar.context;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class ApplicationContextHolder {
    private static Configuration conf;
    private static DisplayMetrics metrics;
    private static AssetManager assertMng;

    public static String getStringById(int id){
        Resources resources = new android.content.res.Resources(assertMng, metrics, conf);

        return resources.getString(id);
    }

    public static void changeApplicationContext(Configuration conf, DisplayMetrics metrics, AssetManager asmng ){
        conf = conf;
        metrics = metrics;
        assertMng = asmng;
    }
}