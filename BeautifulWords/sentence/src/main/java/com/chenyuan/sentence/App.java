package com.chenyuan.sentence;

import android.app.Application;
import android.content.Context;

import com.apkfuns.logutils.LogUtils;
import com.chenyuan.sentence.pub.CrashHandler;

import im.fir.sdk.FIR;


public class App extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        initUtil();
    }

    private void initUtil() {

        FIR.init(this);

        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());

        LogUtils.configAllowLog = true;
        LogUtils.configTagPrefix = "lnyp-";

    }
}
