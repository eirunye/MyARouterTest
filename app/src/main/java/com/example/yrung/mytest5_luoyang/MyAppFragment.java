package com.example.yrung.mytest5_luoyang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.yrung.mytest5_luoyang.constants.ConstantApi;


@Route(path = ConstantApi.ROUTER_FRAGMENT_TEST_1)
public class MyAppFragment extends Fragment {



    public static MyAppFragment newInstance(String param1, String param2) {
        MyAppFragment fragment = new MyAppFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_app, container, false);
    }

}
