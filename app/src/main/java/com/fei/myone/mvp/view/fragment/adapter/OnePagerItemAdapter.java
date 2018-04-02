package com.fei.myone.mvp.view.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fei.myone.R;
import com.fei.myone.bean.OneListBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fei on 2018/4/2.
 */

public class OnePagerItemAdapter extends RecyclerView.Adapter<OnePagerItemAdapter.NewsViewHolder> {
    private Context mContext;
    private List<OneListBean> mOneList;
    private long lastPos = -1;

    public OnePagerItemAdapter(Context context, List<OneListBean> mOneList) {
        this.mContext = context;
        this.mOneList = mOneList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_onepageritem, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final OneListBean oneListBean = mOneList.get(position);
        if(oneListBean == null){
            return;
        }
        bindViewHolder(holder,position,oneListBean);
    }

    private void bindViewHolder(NewsViewHolder holder, int position, OneListBean oneListBean) {
        holder.tv_tv.setText(oneListBean.getTitle());
//        holder.mTvTitle.setText(oneListBean.getTitle());
//        List<String> images = oneListBean.getImages();
//        if(images != null && images.size() > 0){
//            Glide.with(mContext).load(images.get(0)).placeholder(R.drawable.ic_placeholder).into(holder.mIvNews);
//            holder.mCvItem.setOnClickListener(getListener(holder,news));
//        }
    }

    private View.OnClickListener getListener(NewsViewHolder holder, final OneListBean news) {
        return new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        };
    }

    @Override
    public int getItemCount() {
        return mOneList == null ? 0 : mOneList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_tv)
        TextView tv_tv;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}