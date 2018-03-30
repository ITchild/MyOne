package com.fei.myone.mvp.view.fragment;

import android.view.View;

import com.fei.myone.BaseFragment;
import com.fei.myone.R;

import butterknife.ButterKnife;

/**
 * Created by fei on 2018/3/30.
 */

public class OneFragment extends BaseFragment {
    @Override
    public int getLayout() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this,view);
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
