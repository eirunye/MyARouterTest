package com.example.yrung.myaroutertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.yrung.myaroutertest.constants.ConstantApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                ARouter.getInstance()
                        .build(ConstantApi.ROUTER_TEST_1)
                        .navigation();
                break;
            case R.id.button2:
                ARouter.getInstance()
                        .build(ConstantApi.ROUTER_MODULE_PROJECT)
                        .navigation();
                break;
            case R.id.button3:

                break;
            case R.id.button4:
                ARouter.getInstance()
                        .build(ConstantApi.ROUTER_PARAMETER_1)
                        .withString("name", "老王")
                        .withInt("age", 23)
                        .navigation();
                break;
            case R.id.button5://跳转到module中

                ARouter.getInstance()
                        .build(ConstantApi.ROUTER_MODULE_PROJECT_PARAMETER)
                        .withString("name", "老王")
                        .withInt("age", 22)
                        .navigation();
                break;
            case R.id.button6:
                ARouter.getInstance()
                        .build(ConstantApi.ROUTER_WEB_URL_1)
                        .withString("url", "file:///android_asset/hello.html")
                        .navigation();

                break;
            case R.id.button7:
                Log.e("===========>", "hahha");
                ARouter.getInstance()
                        .build(ConstantApi.ROUTER_MODULE_PROJECT_INTERCEPRTOT)
                        .navigation(this, new NavCallback() {
                            @Override
                            public void onArrival(Postcard postcard) {
//                                Log.e("ARouter", postcard.toString());
                                Log.e("ARouter", "操作数据");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.e("ARouter", "被拦截了");
                            }
                        });
                break;
        }
    }
}
