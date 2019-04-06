package com.example.mycommunity.function;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mycommunity.R;
import com.example.mycommunity.function.forSecretary.ForSecretaryActivity;
import com.example.mycommunity.function.forWater.ForWaterActivity;
import com.example.mycommunity.function.repair.RepairActivity;

import java.util.List;

public class FunctionCardAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<Function> functions;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;

        ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            imageView = view.findViewById(R.id.function_img);
            textView = view.findViewById(R.id.function_text);
        }
    }

    FunctionCardAdapter(List<Function> functions) {
        this.functions = functions;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.function_card_item, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent;
                        int position = holder.getAdapterPosition();
                        switch (position) {
                            case 0:
                                intent = new Intent(mContext, RepairActivity.class);
                                break;
                            case 1:
                                intent = new Intent(mContext, ForWaterActivity.class);
                                break;
                            case 2:
                                intent = new Intent(mContext, ForSecretaryActivity.class);
                                break;
                            default:
                                intent = new Intent();
                        }
                        mContext.startActivity(intent);
                    }
                });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Function function = functions.get(position);

        ((ViewHolder) holder).textView.setText(function.getFunctionText());
        Glide.with(mContext).load(function.getImgId()).into(((ViewHolder) holder).imageView);
    }

    @Override
    public int getItemCount() {
        return functions.size();
    }
}
