package com.fei.myone.mvp.view.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fei.myone.R;
import com.fei.myone.bean.OneDataBean;
import com.fei.myone.bean.OneListBean;
import com.fei.myone.ui.XCRoundImageView;

import org.w3c.dom.Text;

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

        switch (oneListBean.getContent_type()){
            case 0 ://摄影
                disPlayTakePhoto(holder,oneListBean);
                break;
            case 1 ://ONE STORY
                disPlayArticle(holder,oneListBean,"ONE STORY");
                break;
            case 2 ://连载
                disPlayArticle(holder,oneListBean,"连载");
                break;
            case 3 ://问答
                disPlayArticle(holder,oneListBean,"问答");
                break;
            case 4 ://音乐
                disPlayMusic(holder,oneListBean);
                break;
            case 5 ://影视
                disPlayArticle(holder,oneListBean,"影视");
                break;
            case 8 ://电台
                disPlayRadio(holder,oneListBean);
                break;
        }
    }

    /**
     * 显示电台的布局
     * @param holder
     * @param oneListBean
     */

    private void disPlayRadio(NewsViewHolder holder, OneListBean oneListBean){
        holder.item_oneList_takePhoto_ll.setVisibility(View.GONE);
        holder.item_oneList_Article_ll.setVisibility(View.GONE);
        holder.item_oneList_music_ll.setVisibility(View.GONE);
        holder.item_oneList_radio_ll.setVisibility(View.VISIBLE);

        String img_url = oneListBean.getImg_url();
        if(img_url != null){
            Glide.with(mContext).load(img_url).placeholder(R.mipmap.default_update_img).into(holder.oneListRadio_iv);
        }

        holder.oneListRadio_title_tv.setText(oneListBean.getTitle());
        holder.oneListRadio_laud_tv.setText(oneListBean.getLike_count() + "");
    }

    /**
     * 显示音乐的布局
     * @param holder
     * @param oneListBean
     */
    private void disPlayMusic(NewsViewHolder holder, OneListBean oneListBean){
        holder.item_oneList_takePhoto_ll.setVisibility(View.GONE);
        holder.item_oneList_Article_ll.setVisibility(View.GONE);
        holder.item_oneList_music_ll.setVisibility(View.VISIBLE);
        holder.item_oneList_radio_ll.setVisibility(View.GONE);

        holder.oneListmusic_title_tv.setText(oneListBean.getTitle());
        holder.oneListmusic_author_tv.setText("文/"+oneListBean.getAuthor().getUser_name());
        String img_url = oneListBean.getImg_url();
        if(img_url != null){
            Glide.with(mContext).load(img_url).placeholder(R.mipmap.default_update_img).into(holder.oneListmusic_Roundiv);
        }
        holder.oneListmusic_musicA_tv.setText(oneListBean.getMusic_name()+" · "
                +oneListBean.getAudio_author()+" | "+oneListBean.getAudio_album());

        holder.oneListmusic_con_tv.setText(oneListBean.getForward());
        holder.oneListmusic_date_tv.setText(oneListBean.getLast_update_date());
        holder.oneListmusic_laud_tv.setText(oneListBean.getLike_count()+"");
    }

    /**
     * 显示摄影的布局
     * @param holder
     * @param oneListBean
     */
    private void disPlayTakePhoto(NewsViewHolder holder, OneListBean oneListBean){
        holder.item_oneList_takePhoto_ll.setVisibility(View.VISIBLE);
        holder.item_oneList_Article_ll.setVisibility(View.GONE);
        holder.item_oneList_music_ll.setVisibility(View.GONE);
        holder.item_oneList_radio_ll.setVisibility(View.GONE);

        String image_url = oneListBean.getImg_url();
        if(image_url != null){
            Glide.with(mContext).load(image_url).placeholder(R.mipmap.default_update_img).into(holder.oneListTakePhoto_iv);
        }
        holder.oneListTakePhoto_author_tv.setText(oneListBean.getTitle()+"|"+oneListBean.getPic_info());
        holder.oneListTakePhoto_con_tv.setText(oneListBean.getForward());
        holder.oneListTakePhoto_conAuthor_tv.setText(oneListBean.getWords_info());
        holder.oneListTakePhoto_laud_tv.setText(oneListBean.getLike_count()+"");
    }

    /**
     * 显示文章的布局
     * @param holder
     * @param oneListBean
     */
    private void disPlayArticle(NewsViewHolder holder,OneListBean oneListBean,String type){
        holder.item_oneList_takePhoto_ll.setVisibility(View.GONE);
        holder.item_oneList_Article_ll.setVisibility(View.VISIBLE);
        holder.item_oneList_music_ll.setVisibility(View.GONE);
        holder.item_oneList_radio_ll.setVisibility(View.GONE);

        holder.oneListArticle_type_tv.setText("-"+type+"-");
        holder.oneListArticle_title_tv.setText(oneListBean.getTitle());
        if(type.equals("问答")) {
            holder.oneListArticle_author_tv.setText(oneListBean.getAnswerer().getUser_name());
        }else{
            holder.oneListArticle_author_tv.setText("文/"+oneListBean.getAuthor().getUser_name());
        }
        if(type.equals("影视")){
            holder.oneListArticle_author_ll.setVisibility(View.GONE);
            holder.oneListArticle_authorMoive_ll.setVisibility(View.VISIBLE);
            String img_url = oneListBean.getImg_url();
            if (img_url != null) {
                Glide.with(mContext).load(img_url).placeholder(R.mipmap.default_update_img).into(holder.oneListArticleMoive_iv);
            }
            holder.oneListArticle_conMoive_tv.setText(oneListBean.getForward());
            holder.oneListArticle_conAuthor_tv.setText("--《"+oneListBean.getSubtitle()+"》");
        }else {
            holder.oneListArticle_author_ll.setVisibility(View.VISIBLE);
            holder.oneListArticle_authorMoive_ll.setVisibility(View.GONE);
            String img_url = oneListBean.getImg_url();
            if (img_url != null) {
                Glide.with(mContext).load(img_url).placeholder(R.mipmap.default_update_img).into(holder.oneListArticle_iv);
            }
            holder.oneListArticle_con_tv.setText(oneListBean.getForward());
        }
        holder.oneListArticle_date_tv.setText(oneListBean.getLast_update_date());
        holder.oneListArticle_laud_tv.setText(oneListBean.getLike_count()+"");
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
        /*************摄影布局****************/
        @Bind(R.id.item_oneList_takePhoto_ll)
        LinearLayout item_oneList_takePhoto_ll;
        @Bind(R.id.oneListTakePhoto_iv)
        ImageView oneListTakePhoto_iv;
        @Bind(R.id.oneListTakePhoto_author_tv)
        TextView oneListTakePhoto_author_tv;
        @Bind(R.id.oneListTakePhoto_con_tv)
        TextView oneListTakePhoto_con_tv;
        @Bind(R.id.oneListTakePhoto_conAuthor_tv)
        TextView oneListTakePhoto_conAuthor_tv;

        @Bind(R.id.oneListTakePhoto_laud_tv)
        TextView oneListTakePhoto_laud_tv;
        /*****************文章的布局******************/
        @Bind(R.id.item_oneList_Article_ll)
        LinearLayout item_oneList_Article_ll;
        @Bind(R.id.oneListArticle_type_tv)
        TextView oneListArticle_type_tv;
        @Bind(R.id.oneListArticle_title_tv)
        TextView oneListArticle_title_tv;
        @Bind(R.id.oneListArticle_author_tv)
        TextView oneListArticle_author_tv;
        @Bind(R.id.oneListArticle_author_ll)
        LinearLayout oneListArticle_author_ll;
        @Bind(R.id.oneListArticle_iv)
        ImageView oneListArticle_iv;
        @Bind(R.id.oneListArticle_con_tv)
        TextView oneListArticle_con_tv;
        @Bind(R.id.oneListArticle_authorMoive_ll)
        LinearLayout oneListArticle_authorMoive_ll;
        @Bind(R.id.oneListArticleMoive_iv)
        ImageView oneListArticleMoive_iv;
        @Bind(R.id.oneListArticle_conMoive_tv)
        TextView oneListArticle_conMoive_tv;
        @Bind(R.id.oneListArticle_conAuthor_tv)
        TextView oneListArticle_conAuthor_tv;
        @Bind(R.id.oneListArticle_date_tv)
        TextView oneListArticle_date_tv;
        @Bind(R.id.oneListArticle_laud_tv)
        TextView oneListArticle_laud_tv;
        /****************音乐的布局*******************/
        @Bind(R.id.item_oneList_music_ll)
        LinearLayout item_oneList_music_ll;
        @Bind(R.id.oneListmusic_title_tv)
        TextView oneListmusic_title_tv;
        @Bind(R.id.oneListmusic_author_tv)
        TextView oneListmusic_author_tv;
        @Bind(R.id.oneListmusic_Roundiv)
        XCRoundImageView oneListmusic_Roundiv;
        @Bind(R.id.oneListmusic_play_iv)
        ImageView oneListmusic_play_iv;
        @Bind(R.id.oneListmusic_musicA_tv)
        TextView oneListmusic_musicA_tv;
        @Bind(R.id.oneListmusic_con_tv)
        TextView oneListmusic_con_tv;
        @Bind(R.id.oneListmusic_date_tv)
        TextView oneListmusic_date_tv;
        @Bind(R.id.oneListmusic_laud_tv)
        TextView oneListmusic_laud_tv;
        /****************电台的布局*******************/
        @Bind(R.id.item_oneList_radio_ll)
        LinearLayout item_oneList_radio_ll;
        @Bind(R.id.oneListRadio_iv)
        ImageView oneListRadio_iv;
        @Bind(R.id.oneListRadio_title_tv)
        TextView oneListRadio_title_tv;
        @Bind(R.id.oneListRadio_iv_huan)
        ImageView oneListRadio_iv_huan;
        @Bind(R.id.oneListRadio_laud_tv)
        TextView oneListRadio_laud_tv;


        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}