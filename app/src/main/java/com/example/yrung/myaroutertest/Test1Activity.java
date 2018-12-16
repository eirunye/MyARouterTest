package com.example.yrung.myaroutertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.yrung.myaroutertest.constants.ConstantApi;

@Route(path = ConstantApi.ROUTER_TEST_1, name = ConstantApi.ROUTER_TEST_1_NAME)
public class Test1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
    }
}
