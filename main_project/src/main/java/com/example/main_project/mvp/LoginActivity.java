package com.example.main_project.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.main_project.R;
import com.example.main_project.R2;
import com.example.main_project.bean.User;
import com.example.main_project.constants.ConstantProjectApi;
import com.example.main_project.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录页面
 */

@Route(path = ConstantProjectApi.ROUTER_MODULE_PROJECT_LOGIN, name = "LoginActivity")
public class LoginActivity extends AppCompatActivity {


    @BindView(R2.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R2.id.email)
    AutoCompleteTextView email;
    @BindView(R2.id.password)
    EditText password;
    @BindView(R2.id.email_sign_in_button)
    Button emailSignInButton;
    @BindView(R2.id.email_login_form)
    LinearLayout emailLoginForm;
    @BindView(R2.id.login_form)
    ScrollView loginForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick(R2.id.email_sign_in_button)
    public void onClicked(View view) {
        int id = view.getId();
        if (id == R.id.email_sign_in_button) {
            intoLogin();
        }

    }

    private void intoLogin() {
        String account = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(pass)) {
            Toast.makeText(LoginActivity.this, "账号或者密码为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        if ("admin".equals(account) && "123".equals(pass)) {
            User user = new User();
            user.setUsername(account);
            user.setPassword(pass);
            user.setLogin(true);
            SharedPreferencesUtil.putData("Login", user);
        } else {
            Toast.makeText(LoginActivity.this, "登录失败!", Toast.LENGTH_LONG).show();
        }
    }
}

