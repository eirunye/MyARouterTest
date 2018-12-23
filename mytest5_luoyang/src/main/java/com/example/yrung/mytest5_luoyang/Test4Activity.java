package com.example.yrung.mytest5_luoyang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.yrung.mytest5_luoyang.constants.ConstantApi;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = ConstantApi.ROUTER_TEST4_INTERCEPRTOT, name = "Test4Activity")
public class Test4Activity extends AppCompatActivity {

    public static final String TAG = Test4Activity.class.getSimpleName();
    @Autowired
    String extra;
    @BindView(R.id.text2)
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
        Log.e(TAG, extra);
        text2.setText("拦截器添加的参数:" + extra);
    }
}
