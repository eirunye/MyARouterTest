package com.example.yrung.myaroutertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.yrung.myaroutertest.constants.ConstantApi;

import butterknife.BindView;
import butterknife.ButterKnife;


@Route(path = ConstantApi.ROUTER_PARAMETER_1)
public class ParameterActivity extends AppCompatActivity {

    @Autowired
    public String name;
    @Autowired
    public int age;
    @BindView(R.id.text_parameter)
    TextView textParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
        Log.d("param", name + age);
        textParameter.setText(name + "\n" + age);
    }
}
