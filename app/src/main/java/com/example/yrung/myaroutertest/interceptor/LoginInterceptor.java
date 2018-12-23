package com.example.yrung.myaroutertest.interceptor;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.main_project.bean.User;
import com.example.main_project.utils.SharedPreferencesUtil;
import com.example.yrung.myaroutertest.MainActivity;
import com.example.yrung.myaroutertest.constants.ConstantApi;
import com.example.yrung.myaroutertest.other.MainLooper;

/**
 * Author Eirunye
 * Created by on 2018/12/23.
 * Describe 登录拦截器
 */

@Interceptor(priority = 1)
public class LoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (ConstantApi.ROUTER_MODULE_PROJECT_DETAIL.equals(postcard.getPath())) {

            User user = (User) SharedPreferencesUtil.getData("login", new User());
            if (!user.isLogin()) {
                final AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.getThis());
                ab.setCancelable(false);
                ab.setTitle("温馨提醒");
                ab.setMessage("你还未登录,请登录吧！");
                ab.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callback.onContinue(postcard);
                    }
                });

                ab.setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ARouter.getInstance().build(ConstantApi.ROUTER_MODULE_PROJECT_LOGIN).navigation();

                        callback.onContinue(postcard);
                    }
                });

                MainLooper.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ab.create().show();
                    }
                });
            }

        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }
}
