package com.fei.myone.mvp.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import com.fei.myone.utils.Constant;
import com.fei.myone.utils.StatusBarUtils;

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

    private Fragment currentFragment;

    @Inject
    MainPersenter mainPersenter;

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
        currentFragment = mainPersenter.getFristFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_dis_fl, currentFragment).commit();
    }

    @Override
    public void initListener() {

        main_tabGroup_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId ) {
                    case R.id.main_one_rb:
                        mainPersenter.changeFragment(0);
                        break;
                    case R.id.main_all_rb :
                        mainPersenter.changeFragment(1);
                        break;
                    case R.id.main_me_rb :
                        mainPersenter.changeFragment(2);
                        break;
                }
            }
        });
    }

    @Override
    public void changeFragment(Fragment fragment,int currId,int forntId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(currId > forntId) {
            transaction.setCustomAnimations(R.anim.side_right_in, R.anim.side_left_out);
        }else{
            transaction.setCustomAnimations(R.anim.side_left_in, R.anim.side_right_out);
        }
        if (!fragment.isAdded()) {
            transaction.hide(currentFragment).add(R.id.main_dis_fl, fragment).commit();
        } else {
            transaction.hide(currentFragment).show(fragment).commit();
        }
        currentFragment = fragment;
    }

    @Override
    public void setupComponent() {
        DaggerMainComponent.builder().mainMoudel(new MainMoudel(this)).build().Inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPersenter.detachView();
        EventBus.getDefault().unregister(this);
    }

}
