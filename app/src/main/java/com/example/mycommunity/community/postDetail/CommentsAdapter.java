package com.example.mycommunity.community.postDetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mycommunity.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentsAdapter extends RecyclerView.Adapter {
    private List<Comment> comments;

    public CommentsAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView userIc;
        TextView username;
        TextView replyContent;

        ViewHolder(View view) {
            super(view);
            userIc = view.findViewById(R.id.reply_ic);
            username = view.findViewById(R.id.reply_username);
            replyContent = view.findViewById(R.id.reply_content);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.reply_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        holder.replyContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Comment comment = comments.get(position);
        ViewHolder holder = (ViewHolder)viewHolder;
        holder.replyContent.setText(comment.getContent());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}
