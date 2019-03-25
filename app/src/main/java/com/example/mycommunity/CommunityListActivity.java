package com.example.mycommunity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mycommunity.JsonEntity.Data;
import com.example.mycommunity.JsonEntity.ReturnMsg;
import com.example.mycommunity.Login.CommunityListAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CommunityListActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Gson gson = new Gson();
    private CommunityListAdapter adapter;
    private RecyclerView recyclerView;
    private String url = "http://192.168.123.50:8585/chengfeng/community/listall";
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            progressBar.setVisibility(View.INVISIBLE);
            if (msg.what == 0) {
                ReturnMsg returnMsg = (ReturnMsg) msg.obj;
                switch (returnMsg.getStatus()) {
                    case 10001:
                        List<Data> data = returnMsg.getData();
                        adapter = new CommunityListAdapter(data);
                        recyclerView.setLayoutManager(new LinearLayoutManager(CommunityListActivity.this));
                        recyclerView.setAdapter(adapter);
                        break;
                    default:
                        Toast.makeText(CommunityListActivity.this, returnMsg.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(CommunityListActivity.this, "服务器错误", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });
    private Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Message message = handler.obtainMessage(1);
            handler.sendMessage(message);
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            ReturnMsg returnMsg = gson.fromJson(response.body().string(), ReturnMsg.class);
            Message message = handler.obtainMessage(0, returnMsg);
            handler.sendMessage(message);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_list);
        progressBar = findViewById(R.id.community_list_progress_bar);
        recyclerView = findViewById(R.id.community_list_recycler_view);
        NetworkModule.get(url, callback);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
