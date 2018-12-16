package com.example.main_project.mvp;

import android.media.audiofx.AutomaticGainControl;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.main_project.R;
import com.example.main_project.R2;
import com.example.main_project.constants.ConstantProjectApi;

import butterknife.BindView;
import butterknife.ButterKnife;


@Route(path = ConstantProjectApi.ROUTER_MODULE_PROJECT_PARAMETER)
public class ModuleParameterActivity extends AppCompatActivity {

    public static final String TAG = ModuleParameterActivity.class.getSimpleName();
    @BindView(R2.id.text2)
    TextView text2;

    @Autowired
    public String name;
    @Autowired
    public int age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_parameter);
        ButterKnife.bind(this);

        ARouter.getInstance().inject(this);

        Log.e(TAG, name + "\n" + age);

        text2.setText(name + "\n" + age);
    }
}
