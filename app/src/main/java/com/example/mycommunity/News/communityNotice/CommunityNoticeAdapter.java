package com.example.mycommunity.news.communityNotice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mycommunity.R;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class CommunityNoticeAdapter extends RecyclerView.Adapter {

    private List<CommunityNotice> notices;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView showTime;

        ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.community_notice_title);
            showTime = view.findViewById(R.id.community_notice_showtime);
        }
    }

    CommunityNoticeAdapter(List<CommunityNotice> notices) {
        this.notices = notices;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.community_notice_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CommunityNotice notice = notices.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.title.setText(notice.getNotice());
        viewHolder.showTime.setText(
                DateFormat.getDateInstance(2).format(new Date(notice.getShowtime())));

    }

    @Override
    public int getItemCount() {
        return notices.size();
    }
}
