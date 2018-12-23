package com.example.yrung.mytest5_luoyang.interceptor;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.main_project.bean.User;
import com.example.main_project.utils.SharedPreferencesUtil;
import com.example.yrung.mytest5_luoyang.MainActivity;
import com.example.yrung.mytest5_luoyang.constants.ConstantApi;
import com.example.yrung.mytest5_luoyang.other.MainLooper;

/**
 * Author Eirunye
 * Created by on 2018/12/23.
 * Describe 登录拦截器
 */

@Interceptor(priority = 1)
public class LoginInterceptor implements IInterceptor {

    public static final String TAG = LoginInterceptor.class.getSimpleName();

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        Log.e(TAG, "=====>" + postcard.getPath());
        if (ConstantApi.ROUTER_MODULE_PROJECT_DETAIL.equals(postcard.getPath())) {
            User user = (User) SharedPreferencesUtil.getData("Login", new User());
            if (!user.isLogin()) {
                final AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.getThis());
                ab.setCancelable(false);
                ab.setTitle("温馨提醒");
                ab.setMessage("你还未登录,请登录吧！");
                ab.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callback.onInterrupt(null);  // 处理完成，交还控制权
//                        callback.onInterrupt(new RuntimeException("我觉得有点异常"));      // 觉得有问题，中断路由流程
                    }
                });

                ab.setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ARouter.getInstance().build(ConstantApi.ROUTER_MODULE_PROJECT_LOGIN).navigation();

//                        callback.onContinue(postcard);
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

        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }
}
