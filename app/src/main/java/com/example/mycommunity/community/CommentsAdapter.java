package com.example.mycommunity.community;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mycommunity.R;
import com.example.mycommunity.community.postDetail.Comment;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentsAdapter extends RecyclerView.Adapter {
    private List<Comment> comments;
    private Context context;

    CommentsAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView userIc;
        TextView userName;
        TextView date;
        TextView content;
        TextView replayCount;

        ViewHolder(View view) {
            super(view);
            userIc = view.findViewById(R.id.post_reply_user_ic);
            userName = view.findViewById(R.id.post_reply_user_name);
            date = view.findViewById(R.id.post_detail_pub_date);
            content = view.findViewById(R.id.post_reply_content);
            replayCount = view.findViewById(R.id.post_reply_count);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.post_replys_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder)viewHolder;
        Comment comment = comments.get(position);


    }

    public int getItemCount(){
        return comments.size();
    }

}

