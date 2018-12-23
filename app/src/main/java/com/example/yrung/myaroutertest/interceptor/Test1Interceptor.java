package com.example.yrung.myaroutertest.interceptor;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.example.yrung.myaroutertest.MainActivity;
import com.example.yrung.myaroutertest.constants.ConstantApi;
import com.example.yrung.myaroutertest.other.MainLooper;

/**
 * Author Eirunye
 * Created by on 2018/12/23.
 * Describe
 */

@Interceptor(priority = 7)
public class Test1Interceptor implements IInterceptor {
    private Context mContext;

    public static final String TAG = Test1Interceptor.class.getSimpleName();

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.e(TAG, "===>" + postcard.getPath());
        if (ConstantApi.ROUTER_TEST4_INTERCEPRTOT.equals(postcard.getPath())) {
            final AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.getThis());
            ab.setCancelable(false);
            ab.setTitle("温馨提醒");
            ab.setMessage("想要跳转到Test4Activity么？(触发了\"/inter/test1\"拦截器，拦截了本次跳转)");
            ab.setNegativeButton("继续", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    callback.onContinue(postcard);
                }
            });
            ab.setNeutralButton("算了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    callback.onInterrupt(null);
                }
            });
            ab.setPositiveButton("加点料", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    postcard.withString("extra", "我是在拦截器中附加的参数");
                    callback.onInterrupt(null);
                }
            });

            MainLooper.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ab.create().show();
                }
            });
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        mContext = context;
        Log.e(TAG, context.toString());
    }
}
