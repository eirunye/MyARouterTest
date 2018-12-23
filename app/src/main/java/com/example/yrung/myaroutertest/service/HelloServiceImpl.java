package com.example.yrung.myaroutertest.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.yrung.myaroutertest.constants.ConstantApi;

/**
 *  HelloServiceImpl 测试
 *
 */
@Route(path = ConstantApi.ROUTER_SERVICE_HELLO_1, name = "HelloServiceImpl")
public class HelloServiceImpl implements HelloService {
    Context mContext;

    @Override
    public void sayHello(String name) {
        Toast.makeText(mContext, "Hello " + name, Toast.LENGTH_SHORT).show();
    }

    /**
     * Do your init work in this method, it well be call when processor has been load.
     *
     * @param context ctx
     */
    @Override
    public void init(Context context) {
        mContext = context;
        Log.e("testService", HelloService.class.getName() + " has init.");
    }
}
