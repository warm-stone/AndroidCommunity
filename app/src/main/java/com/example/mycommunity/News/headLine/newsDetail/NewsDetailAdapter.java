package com.example.mycommunity.news.headLine.newsDetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mycommunity.R;

import java.util.List;

class NewsDetailAdapter extends RecyclerView.Adapter {

    private List<NewsDetail> details;
    private Context context;
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView detailText;
        ImageView detailImg;
        ViewHolder(View view){
            super(view);
            detailText = view.findViewById(R.id.news_detail_text);
            detailImg = view.findViewById(R.id.news_img);
        }
    }

    public NewsDetailAdapter(List<NewsDetail> details){
        this.details = details;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup container, int viewType){
        if (context == null){
            context = container.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.news_detail_item, container, false);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position){
        NewsDetail detail = details.get(position);
        ViewHolder holder = (ViewHolder)viewHolder;
        holder.detailText.setText(detail.getContent());
        Glide.with(context).load(detail.getImageUrl()).into(holder.detailImg);
    }

    @Override
    public int getItemCount(){
        return details.size();
    }
}
