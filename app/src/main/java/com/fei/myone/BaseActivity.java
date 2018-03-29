package com.fei.myone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by fei on 2018/3/20.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        setupComponent();
        initView();
        initData();
        initListener();
    }

    public abstract int getLayout();
    public abstract void initView();
    public abstract void initData();
    public abstract void initListener();
    public abstract void setupComponent();

}
