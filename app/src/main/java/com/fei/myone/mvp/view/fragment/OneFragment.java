package com.fei.myone.mvp.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.fei.myone.BaseFragment;
import com.fei.myone.R;
import com.fei.myone.di.component.DaggerOneFragmentComponent;
import com.fei.myone.di.moudel.OneFragmentMoudel;
import com.fei.myone.mvp.contract.OneFragmentContract;
import com.fei.myone.mvp.persenter.OneFragmentPersenter;
import com.fei.myone.mvp.view.fragment.adapter.OneViewPagerAdapter;
import com.fei.myone.ui.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fei on 2018/3/30.
 */

public class OneFragment extends BaseFragment implements OneFragmentContract.View{

    @Bind(R.id.oneFragment_dis_cvp)
    CustomViewPager oneFragment_dis_cvp;

    private List<Fragment> fragmentData = new ArrayList<>();

    private OneViewPagerAdapter oneViewPagerAdapter;

    @Inject
    OneFragmentPersenter oneFragmentPersenter;

    @Override
    public int getLayout() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this,view);
        oneFragmentPersenter.attachView(this);
    }

    @Override
    public void initData() {
        //获取初始化的时候的Fragment的列表
       oneFragmentPersenter.getInitFragments();

    }

    @Override
    public void initListener() {
        oneFragment_dis_cvp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                oneFragmentPersenter.addFragment(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void setupComponent() {
        DaggerOneFragmentComponent.builder().oneFragmentMoudel(
                new OneFragmentMoudel(this)).build().Inject(this);
    }

    @Override
    public void getInitFragments(List<Fragment> fragments) {
        fragmentData.clear();
        fragmentData.addAll(fragments);
        oneViewPagerAdapter = new OneViewPagerAdapter(getActivity().getSupportFragmentManager(),fragmentData);
        oneFragment_dis_cvp.setAdapter(oneViewPagerAdapter);
        oneFragment_dis_cvp.setCurrentItem(0);
        oneFragment_dis_cvp.setOffscreenPageLimit(2); // 设置viewpager的缓存界面数
        oneFragment_dis_cvp.setPagingEnabled(true);
    }

    @Override
    public void addFragment(List<Fragment> fragments) {
        fragmentData.clear();
        fragmentData.addAll(fragments);
        oneViewPagerAdapter.notifyDataSetChanged();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        oneFragmentPersenter.detachView();
    }
}
