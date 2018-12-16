package com.example.main_project.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.main_project.R;
import com.example.main_project.R2;
import com.example.main_project.constants.ConstantProjectApi;

import butterknife.BindView;
import butterknife.ButterKnife;


@Route(path = ConstantProjectApi.ROUTER_MODULE_PROJECT_INTERCEPROT)
public class InterceptorActivity extends AppCompatActivity {

    @BindView(R2.id.text12)
    TextView text12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interceptor);
        ButterKnife.bind(this);
        String extra = getIntent().getStringExtra("extra");
        if (!TextUtils.isEmpty(extra)) {
            text12.setText(extra);
        }
    }
}
