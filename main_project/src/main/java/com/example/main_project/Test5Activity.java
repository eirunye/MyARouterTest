package com.example.main_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.main_project.constants.ConstantProjectApi;

@Route(path = ConstantProjectApi.ROUTER_MODULE_COMMENT_PAGE)
public class Test5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);
    }
}
