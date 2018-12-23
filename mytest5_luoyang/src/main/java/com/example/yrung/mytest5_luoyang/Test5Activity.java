package com.example.yrung.mytest5_luoyang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.yrung.mytest5_luoyang.constants.ConstantApi;

@Route(path = ConstantApi.ROUTER_MODULE_COMMENT_PAGE)
public class Test5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_5);
    }
}
