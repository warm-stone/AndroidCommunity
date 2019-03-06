package com.example.mycommunity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FunctionCardAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<Function> functions;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            imageView = view.findViewById(R.id.function_img);
            textView = view.findViewById(R.id.function_text);
        }
    }
    public FunctionCardAdapter(List<Function> functions){
        this.functions = functions;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
            View view = LayoutInflater.from(mContext).inflate(R.layout.function_card_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Function function = functions.get(position);

        ((ViewHolder)holder).textView.setText(function.getFunctionText());
        Glide.with(mContext).load(function.getImgId()).into(((ViewHolder)holder).imageView);
    }

    @Override
    public int getItemCount(){
        return functions.size();
    }
}
