package com.example.yrung.myaroutertest.other;

import android.os.Handler;
import android.os.Looper;

/**
 * Author Eirunye
 * Created by on 2018/12/23.
 * Describe
 */
public class MainLooper extends Handler {
    private static MainLooper instance = new MainLooper(Looper.getMainLooper());

    protected MainLooper(Looper looper) {
        super(looper);
    }

    public static MainLooper getInstance() {
        return instance;
    }

    public static void runOnUiThread(Runnable runnable) {
        if(Looper.getMainLooper().equals(Looper.myLooper())) {
            runnable.run();
        } else {
            instance.post(runnable);
        }

    }
}