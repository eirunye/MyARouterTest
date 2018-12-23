package com.example.main_project.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.main_project.R;
import com.example.main_project.constants.ConstantProjectApi;

@Route(path = ConstantProjectApi.ROUTER_MODULE_PROJECT_DETAIL, name = "DetailsActivity")
public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }
}
