package com.fei.myone.mvp.view.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fei.myone.R;
import com.fei.myone.bean.OneListBean;
import com.fei.myone.bean.allbean.AllListBannerBean;
import com.fei.myone.bean.allbean.AllListItemBean;
import com.fei.myone.bean.allbean.AllListSortBean;
import com.fei.myone.ui.XCRoundImageView;
import com.fei.myone.utils.GlideImageLoader;
import com.fei.myone.utils.StringUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fei on 2018/4/19.
 */

public class AllListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<AllListBannerBean> listItemBeens = new ArrayList<>();
    private List<AllListBannerBean> listBannerBeens = new ArrayList<>();
    private List<AllListSortBean> listSortBeens = new ArrayList<>();

    public AllListAdapter(Context context) {
        this.mContext = context;
    }

    public void setListBannerData(List<AllListBannerBean> listBannerBeens){
        this.listBannerBeens = listBannerBeens;
        notifyDataSetChanged();
    }
    public void setItemBannerData(List<AllListBannerBean> listBannerBeens){
        this.listItemBeens = listBannerBeens;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if(viewType == 0) {
            View view = layoutInflater.inflate(R.layout.item_alllist_banner, parent, false);
            return new BannerHolder(view);
        }else if(viewType ==1){
            View view = layoutInflater.inflate(R.layout.item_alllist_sort, parent, false);
            return new SortHolder(view);
        }else{
            View view = layoutInflater.inflate(R.layout.item_alllist_item, parent, false);
            return new ItemHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 0;
        }else if(position == 1){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){
            case 0 :
                bannerBindViewHolder((BannerHolder) holder,position,listBannerBeens);
                break;
            case 1 :
                sortBindViewHolder((SortHolder) holder,position,listSortBeens);
                break;
            case 2 :
                AllListBannerBean listItemBean = listItemBeens.get(position-2);
                itemBindViewHolder((ItemHolder) holder,position,listItemBean);
                break;
        }
    }


    private void bannerBindViewHolder(BannerHolder holder, int position,List<AllListBannerBean> listBannerBeens) {
        List<String> images = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for(AllListBannerBean bannerBean : listBannerBeens){
            images.add(bannerBean.getCover());
            titles.add(bannerBean.getTitle());
        }
        //设置图片加载器
        holder.item_alllist_banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        holder.item_alllist_banner.setImages(images);
        holder.item_alllist_banner.setBannerTitles(titles);
        //banner设置方法全部调用完毕时最后调用
        holder.item_alllist_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        holder.item_alllist_banner.setIndicatorGravity(BannerConfig.RIGHT);
        holder.item_alllist_banner.setViewPagerIsScroll(true);
        holder.item_alllist_banner.start();
    }
    private void sortBindViewHolder(SortHolder holder, int position, List<AllListSortBean> oneListBean) {

    }
    private void itemBindViewHolder(ItemHolder holder, int position, AllListBannerBean listItemBean) {
        holder.item_alllist_item_tv.setText(listItemBean.getTitle());
        Glide.with(mContext).load(listItemBean.getCover()).into(holder.item_alllist_item_iv);
    }

    @Override
    public int getItemCount() {
        return (listItemBeens == null ? 0 : listItemBeens.size()) + 2;
//        return 5;
    }

    //Banner的View布局的绑定
    class BannerHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_alllist_banner)
        Banner item_alllist_banner;

        public BannerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    //Sort的View布局的绑定
    class SortHolder extends RecyclerView.ViewHolder{


        public SortHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    //Item的View布局的绑定
    class ItemHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.item_alllist_item_iv)
        ImageView item_alllist_item_iv;

        @Bind(R.id.item_alllist_item_tv)
        TextView item_alllist_item_tv;


        public ItemHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
