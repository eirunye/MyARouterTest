package com.example.main_project.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.main_project.R;
import com.example.main_project.R2;
import com.example.main_project.constants.ConstantProjectApi;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = ConstantProjectApi.ROUTER_MODULE_PROJECT_DETAIL, name = "DetailsActivity")
public class DetailsActivity extends AppCompatActivity {


    @Autowired
    String newsUrl;
    @BindView(R2.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        if (!TextUtils.isEmpty(newsUrl)) {

            webView.loadUrl(newsUrl);
        }
    }
}
