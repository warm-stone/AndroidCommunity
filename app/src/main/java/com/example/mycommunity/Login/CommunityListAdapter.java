package com.example.mycommunity.Login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mycommunity.JsonEntity.Data;
import com.example.mycommunity.R;
import java.util.List;

public class CommunityListAdapter extends RecyclerView.Adapter {

    private List<Data> datas;
    private Context context;
    public CommunityListAdapter(List<Data> datas){
        this.datas = datas;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.community_list_item_text);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        context = viewGroup.getContext();
        final ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.community_list_item, viewGroup, false));
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
               // ((Activity)context).setResult(Activity.RESULT_OK, );
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        Data data = datas.get(position);
        ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.textView.setText(data.getName());
    }

    @Override
    public int getItemCount(){
        return datas.size();
    }
}
