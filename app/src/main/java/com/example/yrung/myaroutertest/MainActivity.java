package com.example.yrung.myaroutertest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.main_project.utils.SharedPreferencesUtil;
import com.example.yrung.myaroutertest.constants.ConstantApi;
import com.example.yrung.myaroutertest.service.HelloService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static Activity activity;
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
        activity = this;
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9})
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
                //跳转到本地拦截器
                ARouter.getInstance()
                        .build(ConstantApi.ROUTER_TEST4_INTERCEPRTOT)
                        .navigation();
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
                                //操作数据  这里可以如判断是否已经是登录状态，或者其他操作
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.e("ARouter", "被拦截了");
                            }
                        });
                break;

            case R.id.button8:
                ((HelloService) ARouter.getInstance().build(ConstantApi.ROUTER_SERVICE_HELLO_1).navigation()).sayHello("mike");
                break;
            case R.id.button9:

                ARouter.getInstance()
                        .build(ConstantApi.ROUTER_MODULE_PROJECT_DETAIL)
                        .withString("newsId", "10001")
                        .withString("newsUrl", "file:///android_asset/news.html")
                        .navigation();
                break;
        }
    }

    public static Activity getThis() {
        return activity;
    }
}
