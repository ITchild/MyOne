package com.fei.myone.mvp.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.fei.myone.BaseActivity;
import com.fei.myone.R;
import com.fei.myone.bean.EventBusMsgBean;
import com.fei.myone.db.DB_Server;
import com.fei.myone.di.component.DaggerMainComponent;
import com.fei.myone.di.moudel.MainMoudel;
import com.fei.myone.mvp.contract.MainContract;
import com.fei.myone.mvp.persenter.MainPersenter;
import com.fei.myone.mvp.view.fragment.adapter.MainPagerAdapter;
import com.fei.myone.ui.CustomViewPager;
import com.fei.myone.utils.Constant;
import com.fei.myone.utils.StatusBarUtils;
import com.fei.myone.utils.StringUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View{

    @Bind(R.id.main_tabGroupLine_ll)
    LinearLayout main_tabGroupLine_ll;

    @Bind(R.id.main_tabGroup_rg)
    RadioGroup main_tabGroup_rg;

    @Bind(R.id.main_dis_cvp)
    public CustomViewPager main_dis_cvp;

    @Inject
    MainPersenter mainPersenter;

    //退出时的时间
    private long mExitTime;

    private MainPagerAdapter pagerAdapter;
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        StatusBarUtils.setStatusBarLightMode(getWindow());
        mainPersenter.attachView(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void mainEvent(EventBusMsgBean busMsgBean){
        switch (busMsgBean.getFlag()){
            case Constant.DISAPPEARBUTTOMTAB ://底部的Tab消失
                main_tabGroupLine_ll.setVisibility(View.GONE);
                break;
            case Constant.APPEARBUTTOMTAB ://底部的Tab出现
                main_tabGroupLine_ll.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void initData() {
        mainPersenter.getFragments();
    }

    @Override
    public void getFragments(Fragment[] fragments) {
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),fragments);
        main_dis_cvp.setAdapter(pagerAdapter);
        main_dis_cvp.setCurrentItem(0);
        main_dis_cvp.setOffscreenPageLimit(2); // 设置viewpager的缓存界面数
    }

    @Override
    public void initListener() {

        main_tabGroup_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId ) {
                    case R.id.main_one_rb:
                        main_dis_cvp.setCurrentItem(0);
                        break;
                    case R.id.main_all_rb :
                        main_dis_cvp.setCurrentItem(1);
                        break;
                    case R.id.main_me_rb :
                        main_dis_cvp.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    public void setupComponent() {
        DaggerMainComponent.builder().mainMoudel(new MainMoudel(this)).build().Inject(this);
    }

    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            StringUtils.showToast("再按一次退出");
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPersenter.detachView();
        EventBus.getDefault().unregister(this);
    }

}
