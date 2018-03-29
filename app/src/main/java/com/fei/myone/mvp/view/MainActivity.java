package com.fei.myone.mvp.view;

import com.fei.myone.BaseActivity;
import com.fei.myone.R;
import com.fei.myone.db.DB_Server;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private DB_Server db_server;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        db_server = DB_Server.getInstance();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void setupComponent() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
