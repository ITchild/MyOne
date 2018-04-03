package com.fei.myone.mvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.fei.myone.BaseFragment;
import com.fei.myone.R;
import com.fei.myone.bean.OneListBean;
import com.fei.myone.di.component.DaggerOnePagerItemFragmentComponent;
import com.fei.myone.di.moudel.OnePagerItemFragmentMoudel;
import com.fei.myone.mvp.contract.OnePagerItemFragmentContract;
import com.fei.myone.mvp.persenter.OnePagerItemFragmentPersenter;
import com.fei.myone.mvp.view.fragment.adapter.OnePagerItemAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fei on 2018/4/2.
 */

public class OnePagerItemFragment extends BaseFragment implements OnePagerItemFragmentContract.View{

    @Bind(R.id.onePagerItem_dis_xRv)
    XRecyclerView onePagerItem_dis_xRv;

    @Inject
    OnePagerItemFragmentPersenter onePagerItemFragmentPersenter;

    private String date = "0";

    private OnePagerItemAdapter onePagerItemAdapter;

    public void setStringDate(String date){
        this.date = date;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_onepageritem;
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this,view);
        onePagerItemFragmentPersenter.attachView(this);
    }

    @Override
    public void initData() {
        if(date.equals("0")) {
            onePagerItemFragmentPersenter.getToDayOneList();
        }else{
            onePagerItemFragmentPersenter.getDateOneList(date);
        }
    }

    @Override
    public void initListener() {

    }

    @Override
    public void setupComponent() {
        DaggerOnePagerItemFragmentComponent.builder().onePagerItemFragmentMoudel(
                new OnePagerItemFragmentMoudel(this)).build().Inject(this);
    }

    @Override
    public void getToDayOneList(List<OneListBean> listBeens) {
        onePagerItemAdapter = new OnePagerItemAdapter(getContext(),listBeens);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        onePagerItem_dis_xRv.setLayoutManager(layoutManager);

        onePagerItem_dis_xRv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//设置刷新类型
        onePagerItem_dis_xRv.setLoadingMoreProgressStyle(ProgressStyle.Pacman);//设置加载类型
        //  main_disList_xrv.setArrowImageView(R.drawable.iconfont_downgrey);//设置下拉箭头
        onePagerItem_dis_xRv.setRefreshing(true);

        onePagerItem_dis_xRv.setAdapter(onePagerItemAdapter);
    }
}
