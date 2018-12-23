package com.example.main_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.main_project.constants.ConstantProjectApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = ConstantProjectApi.ROUTER_MODULE_PROJECT, name = ConstantProjectApi.ROUTER_PROJECT_MAIN)
public class MainActivity extends AppCompatActivity {

    @BindView(R2.id.button1)
    Button button1;
    @BindView(R2.id.button2)
    Button button2;
    @BindView(R2.id.button3)
    Button button3;
    @BindView(R2.id.button4)
    Button button4;
    @BindView(R2.id.button5)
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
        ButterKnife.bind(this);

        button1.setText("哈哈");
    }

    @OnClick({R2.id.button1, R2.id.button2, R2.id.button3, R2.id.button4, R2.id.button5})
    public void onViewClicked(View view) {

        Log.e("TAG", "===>");
        int i = view.getId();
        if (i == R.id.button1) {
            Log.e("TAG", "===>");
            ARouter.getInstance()
                    .build(ConstantProjectApi.ROUTER_TEST_1)
                    .navigation();

        } else if (i == R.id.button2) {
        } else if (i == R.id.button3) {
        } else if (i == R.id.button4) {
            ARouter.getInstance()
                    .build(ConstantProjectApi.ROUTER_TEST_1)
                    .navigation();
        } else if (i == R.id.button5) {
        }
    }
}
