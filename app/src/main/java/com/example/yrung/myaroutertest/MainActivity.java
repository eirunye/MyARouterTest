package com.example.yrung.myaroutertest;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.main_project.bean.TestObj;
import com.example.yrung.myaroutertest.constants.ConstantApi;
import com.example.yrung.myaroutertest.service.HelloService;
import com.example.yrung.myaroutertest.service.SingleService;

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

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11})
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
                        .build(ConstantApi.ROUTER_MODULE_PROJECT_INTERCEPT)
                        .navigation(this, new NavCallback() {
                            @Override
                            public void onArrival(Postcard postcard) {
//                                Log.e("ARouter", postcard.toString());
                                Log.e("ARouter", "操作数据");
                                //操作数据  这里可以如判断是否已经是登录状态，或者其他操作
                                postcard.withString("extra", "设置NavCallback");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.e("ARouter", "被拦截了");
                            }

                            @Override
                            public void onFound(Postcard postcard) {
                                Log.d("ARouter", "找到了");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Log.d("ARouter", "找不到了");
                            }
                        });
                break;

            case R.id.button8:
                ((HelloService) ARouter.getInstance().build(ConstantApi.ROUTER_SERVICE_HELLO_1).navigation()).sayHello("mike");
                break;
            case R.id.button9:

                ARouter.getInstance()
                        .build(ConstantApi.ROUTER_MODULE_PROJECT_DETAIL) //
                        .withString("newsId", "10001")
                        .withString("newsUrl", "file:///android_asset/news.html")
                        .withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                        .navigation();
                break;
            case R.id.button10:
                //设置
                ARouter.getInstance().navigation(SingleService.class).sayHello("Mike");
                break;
            case R.id.button11://跳转1_Fragment
                //设置group
                Fragment fragment = (Fragment) ARouter.getInstance().build(ConstantApi.ROUTER_FRAGMENT_TEST_1).navigation(this, new NavCallback() {
                    @Override
                    public void onArrival(Postcard postcard) {

                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Log.e("ARouter", "被拦截了");
                    }

                    @Override
                    public void onFound(Postcard postcard) {
                        Log.d("ARouter", "找到了");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        Log.d("ARouter", "找不到了");
                    }
                });
                Toast.makeText(this, "找到Fragment:" + fragment.toString(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public static Activity getThis() {
        return activity;
    }

}
