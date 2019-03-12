package com.example.mycommunity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class test extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button button  = findViewById(R.id.button);
        button.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"),"{\"password\":\"1234567890\",\"phone\":\"1234567890\",\"username\":\"12345\",\"baseObjId\":0}");
            Request request = new Request.Builder().url("http://47.95.244.237:9990/chengfeng/per/registry").post(requestBody).build();
            client.newCall(request).enqueue(callback);
        }
    };

    Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, final Response response) throws IOException {

            final String s = response.body().string();
            Log.w("test",s);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //Toast.makeText(test.this,returnMsg.getMessage(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(test.this,s,Toast.LENGTH_SHORT).show();
                }
            });
        }
    };
}
