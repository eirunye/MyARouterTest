package com.example.mytest2.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Author Eirunye
 * Created by on 2018/12/16.
 * Describe
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        if (BuildConfig.DEBUG) {
            ARouter.openLog();//打开日志
            ARouter.openDebug();//打开调式模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
        ARouter.init(this);

    }
}
