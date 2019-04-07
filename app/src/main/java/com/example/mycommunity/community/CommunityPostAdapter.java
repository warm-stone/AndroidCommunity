package com.example.mycommunity.community;

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

import java.util.ArrayList;
import java.util.List;

public class CommunityPostAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<CommunityPost> posts = new ArrayList<>();
    private final static int COMMON_POST = 1;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView userImg;
        TextView userName;
        TextView postTime;
        TextView postTitle;
        ImageView postImg;
        TextView heartCount;
        TextView commentsCount;

        public ViewHolder(View view) {
            super(view);
            this.userImg = view.findViewById(R.id.community_icon_img);
            this.userName = view.findViewById(R.id.community_user_name);
            this.postTime = view.findViewById(R.id.community_post_time);
            this.postTitle = view.findViewById(R.id.community_post_title);
            this.postImg = view.findViewById(R.id.community_post_img);
            this.heartCount = view.findViewById(R.id.community_heart_count_text_view);
            this.commentsCount = view.findViewById(R.id.community_comments_count_text_View);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return posts.get(position).getType();
    }

    public CommunityPostAdapter(List<CommunityPost> posts){
        this.posts = posts;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(context == null){
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.community_post_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        CommunityPost communityPost = posts.get(position);
        switch (communityPost.getType()){
            case 1:
                ViewHolder viewHolder = (ViewHolder)holder;
                //Glide.with(context).load(communityPost.getUserImg()).into(viewHolder.userImg);
                viewHolder.userName.setText(String.valueOf(communityPost.getUserId()));
                //viewHolder.postTime.setText(communityPost.getPostTime());
                viewHolder.postTitle.setText(communityPost.getTitle());
                Glide.with(context).load(communityPost.getImgUrl()).into(viewHolder.postImg);
                viewHolder.heartCount.setText(String.valueOf(communityPost.getStar()));
                viewHolder.commentsCount.setText(String.valueOf(communityPost.getComments()));
                break;
        }
    }

    @Override
    public int getItemCount(){
        return posts.size();
    }
}
