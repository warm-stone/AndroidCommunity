package com.example.mycommunity.community;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.community.postDetail.commonPost.PostDetailActivity;

import java.util.List;

public class CommunityPostAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<CommunityPost> posts;
    private final static int COMMON_POST = 1;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            return false;
        }
    });

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userImg;
        TextView userName;
        TextView postTime;
        TextView postTitle;
        TextView postContent;
        ImageView postImg;
        ImageView heart;
        ImageView comments;
        TextView heartCount;
        TextView commentsCount;

        public ViewHolder(View view) {
            super(view);
            userImg = view.findViewById(R.id.community_icon_img);
            userName = view.findViewById(R.id.community_user_name);
            postTime = view.findViewById(R.id.community_post_time);
            postTitle = view.findViewById(R.id.community_post_title);
            postContent = view.findViewById(R.id.community_post_content);
            postImg = view.findViewById(R.id.community_post_img);
            heart = view.findViewById(R.id.community_icon_heart);
            comments = view.findViewById(R.id.community_icon_comment);
            heartCount = view.findViewById(R.id.community_heart_count_text_view);
            commentsCount = view.findViewById(R.id.community_comments_count_text_View);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return posts.get(position).getType();
    }

    public CommunityPostAdapter(List<CommunityPost> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (context == null) {
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.community_post_item, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);
        final int position = holder.getAdapterPosition();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(context, PostDetailActivity.class);
                intent.putExtra("postDetail", posts.get(position));
                context.startActivity(intent);
            }
        });
        holder.heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NetworkModule().post("/news/collect/" + position, "", handler, context);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CommunityPost communityPost = posts.get(position);
                ViewHolder viewHolder = (ViewHolder) holder;
                //Glide.with(context).load(communityPost.getUserImg()).into(viewHolder.userImg);
                viewHolder.userName.setText(String.valueOf(communityPost.getUserId()));
                //viewHolder.postTime.setText(communityPost.getPostTime());
                viewHolder.postTitle.setText(communityPost.getTitle());
                viewHolder.postContent.setText(communityPost.getDescription());
                Glide.with(context).load(communityPost.getImgUrl()).into(viewHolder.postImg);
                viewHolder.heartCount.setText(String.valueOf(communityPost.getStar()));
                viewHolder.commentsCount.setText(String.valueOf(communityPost.getComments()));
    }

    @Override
    public int getItemCount() {
         return posts.size();
    }
}
