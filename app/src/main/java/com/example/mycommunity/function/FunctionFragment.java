package com.example.mycommunity.function;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycommunity.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FunctionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.function_layout, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        Function[] functions = new Function[]{
                new Function(R.drawable.ic_repair, "立即报修"),
                new Function(R.drawable.ic_for_water, "送水服务"),
                new Function(R.drawable.ic_secretary, "找书记"),
                new Function(R.drawable.ic_vote, "投票")};
        List<Function> functionList = Arrays.asList(functions);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        RecyclerView recyclerView = view.findViewById(R.id.function_recycle_view);
        recyclerView.setLayoutManager(layoutManager);
        FunctionCardAdapter functionCardAdapter = new FunctionCardAdapter(functionList);
        recyclerView.setAdapter(functionCardAdapter);
    }
}
