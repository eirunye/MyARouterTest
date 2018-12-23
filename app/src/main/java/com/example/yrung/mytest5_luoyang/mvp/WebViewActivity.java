package com.example.yrung.mytest5_luoyang.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.yrung.mytest5_luoyang.R;
import com.example.yrung.mytest5_luoyang.constants.ConstantApi;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = ConstantApi.ROUTER_WEB_URL_1)
public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView webview;

    @Autowired
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
        webview.loadUrl(url);

        //或者webview.loadUrl(getIntent().getStringExtra("url"));
    }
}
