package com.example.main_project.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.main_project.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    public void intoActivity(String url){

    }

    protected abstract int getLayoutId();
}
