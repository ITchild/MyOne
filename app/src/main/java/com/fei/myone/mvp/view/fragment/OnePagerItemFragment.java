package com.fei.myone.mvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fei.myone.BaseFragment;
import com.fei.myone.R;
import com.fei.myone.bean.EventBusMsgBean;
import com.fei.myone.bean.OneListBean;
import com.fei.myone.bean.WeatherBean;
import com.fei.myone.di.component.DaggerOnePagerItemFragmentComponent;
import com.fei.myone.di.moudel.OnePagerItemFragmentMoudel;
import com.fei.myone.mvp.contract.OnePagerItemFragmentContract;
import com.fei.myone.mvp.persenter.OnePagerItemFragmentPersenter;
import com.fei.myone.mvp.view.fragment.adapter.OnePagerItemAdapter;
import com.fei.myone.utils.Constant;
import com.fei.myone.utils.StringUtils;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

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
    private int recycleViewDistance = 0;
    private boolean isButtonTab = true;

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
        onePagerItem_dis_xRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                recycleViewDistance += dy;
                if(recycleViewDistance > 300 && !isButtonTab){
                    EventBusMsgBean eventBusMsgBean = new EventBusMsgBean();
                    eventBusMsgBean.setFlag(Constant.APPEARBUTTOMTAB);
                    EventBus.getDefault().post(eventBusMsgBean);
                    isButtonTab = true;
                }
                if(recycleViewDistance <300 && isButtonTab){
                    EventBusMsgBean eventBusMsgBean = new EventBusMsgBean();
                    eventBusMsgBean.setFlag(Constant.DISAPPEARBUTTOMTAB);
                    EventBus.getDefault().post(eventBusMsgBean);
                    isButtonTab = false;
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
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

    @Override
    public void getToDayWeather(WeatherBean weatherBean) {
        //发送天气的信息
        EventBusMsgBean eventBusMsgBean = new EventBusMsgBean();
        eventBusMsgBean.setFlag(Constant.WEATHERFLAG);
        eventBusMsgBean.setLocation(weatherBean.getCity_name());
        eventBusMsgBean.setTemputure(weatherBean.getTemperature());
        EventBus.getDefault().post(eventBusMsgBean);
    }
}
