package com.fei.myone.mvp.view.fragment;

import android.view.View;

import com.fei.myone.BaseFragment;
import com.fei.myone.R;
import com.fei.myone.db.DB_Server;

/**
 * Created by fei on 2018/3/30.
 */

public class MeFragment extends BaseFragment {

    private DB_Server db_server;

    @Override
    public int getLayout() {
        return R.layout.fragment_me;
    }

    @Override
    public void initView(View view) {
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
}
