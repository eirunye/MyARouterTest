package com.example.yrung.myaroutertest.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.main_project.utils.SharedPreferencesUtil;
import com.example.yrung.myaroutertest.BuildConfig;

/**
 * Author Eirunye
 * Created by on 2018/12/16.
 * Describe
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        if (BuildConfig.APP_DEBUG) {
            ARouter.openLog();//打开日志
            ARouter.openDebug();//打开调式模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
        ARouter.init(this);
        SharedPreferencesUtil.getInstance(this, "app");
    }
}
