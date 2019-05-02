package com.example.mycommunity.news.popertyNotice;

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

public class PropertyNoticeAdapter extends RecyclerView.Adapter {
    private List<PropertyNotice> notices;

    public PropertyNoticeAdapter(List<PropertyNotice> notices) {
        this.notices = notices;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView timeStamp;

        ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.community_notice_title);
            timeStamp = view.findViewById(R.id.community_notice_showtime);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.community_notice_item, viewGroup));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        PropertyNotice notice = notices.get(position);
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.title.setText(notice.getNotice());
        holder.timeStamp.setText(
                DateFormat.getDateInstance(2).format(
                        new Date(notice.getShowtime())
                )
        );

    }

    @Override
    public int getItemCount() {
        return notices.size();
    }
}
