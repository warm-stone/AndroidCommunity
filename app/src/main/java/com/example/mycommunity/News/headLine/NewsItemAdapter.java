package com.example.mycommunity.news.headLine;

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

public class NewsItemAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<News> newsList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImg;
        TextView newsTitle;
        TextView hadSeen;
        TextView hadHeart;
        TextView publishTime;

         ViewHolder(View view) {
            super(view);
            newsImg = view.findViewById(R.id.news_img);
            newsTitle = view.findViewById(R.id.news_title_text_view);
            hadSeen = view.findViewById(R.id.news_had_seen);
            hadHeart = view.findViewById(R.id.news_had_heart);
            publishTime = view.findViewById(R.id.news_publishTime);
        }
    }

    public NewsItemAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (context == null) {
            context = viewGroup.getContext();
        }
            View view = LayoutInflater.from(context).inflate(R.layout.news_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        News news = newsList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.newsTitle.setText(news.getTitle());
        viewHolder.hadSeen.setText(String.valueOf(news.getNews_had_seen()));
        viewHolder.hadHeart.setText(String.valueOf(news.getStarNums()));
        String temp = news.getPublishTime().split("T")[0];
        viewHolder.publishTime.setText(temp);
        Glide.with(context).load(news.getImgId()).into(viewHolder.newsImg);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

}
