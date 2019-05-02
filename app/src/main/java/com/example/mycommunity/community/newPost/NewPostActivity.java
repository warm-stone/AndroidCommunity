package com.example.mycommunity.community.newPost;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.UserNotice;
import com.example.mycommunity.community.CommunityPost;
import com.google.gson.Gson;

public class NewPostActivity extends AppCompatActivity {

    private CommunityPost post = new CommunityPost();
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            ReturnNewPost returnPosts = null;
            try {
                returnPosts = new Gson().fromJson((String) msg.obj, ReturnNewPost.class);
            } catch (Exception e) {
                UserNotice.showToast(NewPostActivity.this, UserNotice.UNFORMATTED_DATA);
            }
            if (msg.what == 0) {
                if (returnPosts != null)
                    post = returnPosts.getData();

            } else {
                switch (msg.what) {
                    case 1:
                        UserNotice.showToast(NewPostActivity.this, UserNotice.NETWORK_CONNECT_FAILURE);
                        break;
                    case 2:
                        UserNotice.showToast(NewPostActivity.this, UserNotice.USER_AUTHENTICATION_FAILURE);
                        break;
                    case 3:
                        netRequest();
                        break;
                    case 4:
                        if (returnPosts != null)
                            UserNotice.showToast(NewPostActivity.this, returnPosts.getMessage());
                        break;
                    case 5:
                        UserNotice.showToast(NewPostActivity.this, UserNotice.UNEXPECTED_STATE);
                        break;
                    default:
                        UserNotice.showToast(NewPostActivity.this, UserNotice.UNEXPECTED_STATE);
                }
            }
            return false;
        }
    });

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        initView();
    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        final TextView postTitle = findViewById(R.id.new_post_title);
        final TextView postDescription = findViewById(R.id.new_post_content);
        TextView postText = findViewById(R.id.new_post_post);
        postText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post.setTitle(postTitle.getText().toString());
                post.setDescription(postDescription.getText().toString());
            }
        });
    }

    private void netRequest() {
        String json;
        if (post != null) {
            json = new Gson().toJson(post);
            new NetworkModule().post("/news/create", json, handler, this);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return true;
    }
}
