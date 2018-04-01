package com.fei.myone.mvp.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.fei.myone.BaseActivity;
import com.fei.myone.R;
import com.fei.myone.db.DB_Server;
import com.fei.myone.di.component.DaggerMainComponent;
import com.fei.myone.di.moudel.MainMoudel;
import com.fei.myone.mvp.contract.MainContract;
import com.fei.myone.mvp.persenter.MainPersenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View{
    private DB_Server db_server;


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
        mainPersenter.attachView(this);
        db_server = DB_Server.getInstance();
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
    }

}
