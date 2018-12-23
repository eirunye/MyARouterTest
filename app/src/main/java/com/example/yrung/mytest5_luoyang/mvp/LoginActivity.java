package com.example.yrung.mytest5_luoyang.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.yrung.mytest5_luoyang.R;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        ButterKnife.bind(this);
    }

}
