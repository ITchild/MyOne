package com.fei.myone.mvp.view.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fei.myone.BaseFragment;
import com.fei.myone.R;
import com.fei.myone.bean.OneListBean;
import com.fei.myone.di.component.DaggerAllFragmentComponent;
import com.fei.myone.di.moudel.AllFragmentMoudel;
import com.fei.myone.mvp.contract.AllFragmentContract;
import com.fei.myone.mvp.persenter.AllFragmentPersenter;
import com.fei.myone.mvp.view.fragment.adapter.AllListAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fei on 2018/3/30.
 */

public class AllFragment extends BaseFragment implements AllFragmentContract.View{

    @Bind(R.id.allTitle_search_iv)
    ImageView allTitle_search_iv;
    @Bind(R.id.all_dis_xrv)
    XRecyclerView all_dis_xrv;


    @Inject
    AllFragmentPersenter allFragmentPersenter;

    private AllListAdapter allListAdapter;
    private List<OneListBean> datalist = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.fragment_all;
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this,view);


    }

    @Override
    public void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        all_dis_xrv.setLayoutManager(layoutManager);
        allListAdapter = new AllListAdapter(getContext(),datalist);
        all_dis_xrv.setAdapter(allListAdapter);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void setupComponent() {
        DaggerAllFragmentComponent.builder().allFragmentMoudel(
                new AllFragmentMoudel(this)).build().Inject(this);
    }
}
