package com.example.mycommunity.Function;

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
import java.util.List;

public class FunctionFragment extends Fragment {
    private static List<Function> functionList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.function_layout, container, false);
        init();
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 4);
        RecyclerView recyclerView = view.findViewById(R.id.function_recycle_view);
        recyclerView.setLayoutManager(layoutManager);
        FunctionCardAdapter functionCardAdapter = new FunctionCardAdapter(functionList);
        recyclerView.setAdapter(functionCardAdapter);
        return view;
    }
    

    private static void init() {
        Function[] functions = {new Function(R.drawable.ic_user, "你好啦")};
        functionList.clear();
        for (int i = 0; i < 20; i++) {
            functionList.add(functions[0]);
        }
    }
}
