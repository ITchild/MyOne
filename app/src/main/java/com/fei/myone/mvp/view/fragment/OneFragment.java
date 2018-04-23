package com.fei.myone.mvp.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.fei.myone.BaseFragment;
import com.fei.myone.R;
import com.fei.myone.bean.EventBusMsgBean;
import com.fei.myone.di.component.DaggerOneFragmentComponent;
import com.fei.myone.di.moudel.OneFragmentMoudel;
import com.fei.myone.mvp.contract.OneFragmentContract;
import com.fei.myone.mvp.persenter.OneFragmentPersenter;
import com.fei.myone.mvp.view.fragment.adapter.OneViewPagerAdapter;
import com.fei.myone.ui.CustomViewPager;
import com.fei.myone.utils.Constant;
import com.fei.myone.utils.DateUtil;
import com.fei.myone.utils.StringUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fei on 2018/3/30.
 */

public class OneFragment extends BaseFragment implements OneFragmentContract.View,View.OnTouchListener{

    @Bind(R.id.onetitle_1_tv)
    TextView onetitle_1_tv;
    @Bind(R.id.onetitle_2_tv)
    TextView onetitle_2_tv;

    @Bind(R.id.onetitle_today_tv)
    TextView onetitle_today_tv;
    @Bind(R.id.onetitle_location_tv)
    TextView onetitle_location_tv;
    @Bind(R.id.onetitle_Temp_tv)
    TextView onetitle_Temp_tv;

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
        EventBus.getDefault().register(this);
        oneFragmentPersenter.attachView(this);
        view.setOnTouchListener(this);
    }

    @Override
    public void initData() {
        //获取初始化的时候的Fragment的列表
        oneFragmentPersenter.getInitFragments();
        oneFragmentPersenter.getDate(0);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void oneFragmentEvent(EventBusMsgBean busMsgBean){
        if(busMsgBean.getFlag() == Constant.WEATHERFLAG){
            onetitle_location_tv.setText(busMsgBean.getLocation());
            onetitle_Temp_tv.setText(busMsgBean.getTemputure()+"℃");
        }
    }

    @OnClick({R.id.onetitle_today_tv})
    public void oneFrafmentClick(View view){
        switch (view.getId()){
            case R.id.onetitle_today_tv :
                oneFragment_dis_cvp.setCurrentItem(0);
                break;
        }
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
                oneFragmentPersenter.getDate(position);
                if(position != 0){
                    onetitle_today_tv.setVisibility(View.VISIBLE);
                    onetitle_location_tv.setVisibility(View.GONE);
                    onetitle_Temp_tv.setVisibility(View.GONE);
                }else{
                    onetitle_today_tv.setVisibility(View.GONE);
                    onetitle_location_tv.setVisibility(View.VISIBLE);
                    onetitle_Temp_tv.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        oneFragment_dis_cvp.requestFocus();
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
        oneFragment_dis_cvp.setOffscreenPageLimit(1); // 设置viewpager的缓存界面数
        oneFragment_dis_cvp.setPagingEnabled(true);
    }

    @Override
    public void addFragment(List<Fragment> fragments) {
        fragmentData.clear();
        fragmentData.addAll(fragments);
        oneViewPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setDate(String date1, String date2) {
        StringUtils.ShowLog(date1+""+date2);
        onetitle_1_tv.setText(date1);
        onetitle_2_tv.setText(date2);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        oneFragmentPersenter.detachView();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
