package com.example.main_project.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.main_project.R;
import com.example.main_project.R2;
import com.example.main_project.bean.TestObj;
import com.example.main_project.constants.ConstantProjectApi;

import butterknife.BindView;
import butterknife.ButterKnife;


@Route(path = ConstantProjectApi.ROUTER_MODULE_PROJECT_INTERCEPT)
public class InterceptorActivity extends AppCompatActivity {

    public static final String TAG = InterceptorActivity.class.getSimpleName();
    @BindView(R2.id.text12)
    TextView text12;

    @Autowired
    String extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interceptor);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
//        String extra = getIntent().getStringExtra("extra");

        if (!TextUtils.isEmpty(extra)) {
            text12.setText(extra);
        }
    }
}
