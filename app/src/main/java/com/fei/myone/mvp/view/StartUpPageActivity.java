package com.fei.myone.mvp.view;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.fei.myone.BaseActivity;
import com.fei.myone.R;
import com.fei.myone.di.component.DaggerStartUpPageComponent;
import com.fei.myone.di.moudel.StartUpPageMoudel;
import com.fei.myone.mvp.contract.StartUpPageContract;
import com.fei.myone.mvp.persenter.StartUpPagePersenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fei on 2018/3/20.
 */

public class StartUpPageActivity extends BaseActivity implements StartUpPageContract.View{

    @Bind(R.id.startUp_disTop_iv)
    ImageView startUp_disTop_iv;
    @Bind(R.id.startUp_disBottom_iv)
    ImageView startUp_disBottom_iv;
    @Bind(R.id.startUp_disBottom_tv)
    TextView startUp_disBottom_tv;

    @Inject
    StartUpPagePersenter startUpPagePersenter;

    @Override
    public int getLayout() {
        return R.layout.activity_startuppage;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        startUpPagePersenter.attachView(this);

        //判断是否为android6.0系统版本，如果是，需要动态添加权限
        startUpPagePersenter.getPermissing();
    }

    @Override
    public void initData() {
        startUpPagePersenter.getWeekViewId();
        startUpPagePersenter.getDateString();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void setupComponent() {
        DaggerStartUpPageComponent.builder().startUpPageMoudel(
                new StartUpPageMoudel(this)).build().Inject(this);
    }

    @Override
    public void setWeekView(int viewId) {
        startUp_disBottom_iv.setImageResource(viewId);
    }


    /**
     * 进入主页
     */
    @Override
    public void entryHomeActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setDate(String date) {
        startUp_disBottom_tv.setText("地球历"+date);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startUpPagePersenter.detachView();
    }
}
