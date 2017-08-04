package com.guohua.dbapp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@ContentView(R.layout.internet)
public class Internet extends AppCompatActivity {
    @ViewInject(R.id.response_text)
    private TextView text;
    @ViewInject(R.id.request_get)
    private Button get_btn;
    @ViewInject(R.id.request_post)
    private Button post_btn;
    //Handler主线程创建---消息的处理主线程
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                String result = (String) msg.obj;
                text.setText(result);//显示结果
            }
        }
    };
    OkHttpClient okHttpClient = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.internet);
        x.view().inject(this);
    }
    @Event(value={R.id.request_get,R.id.request_post})
    private void doEvent(View view){
        switch (view.getId()){
            case R.id.request_get:
                Request request = new Request.Builder()
                        .url("http://www.baidu.com")
                        .get()
                        .build();
                exec(request);
                break;
            case R.id.request_post:
                FormBody.Builder builder1 = new FormBody.Builder();
                FormBody formBody = builder1.add("username", "niuzheng")
                        .add("password", "123456").build();
                Request.Builder builder = new Request.Builder();
                Request request1 = builder.url("http://192.168.40.25:8080/DollChange/user_login")
                        .post(formBody)
                        .build();
                exec(request1);
                break;
        }
    }

    private void exec(Request request) {
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败
                Log.i("异常：","----->"+e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //成功
                Log.i("成功：","--->");
                String s = response.body().string();
                Message message = new Message();
                message.what = 1;
                message.obj = s;
                handler.sendMessage(message);
            }
        });
    }

}
