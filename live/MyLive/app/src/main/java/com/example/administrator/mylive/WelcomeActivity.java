package com.example.administrator.mylive;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import utils.PrefsUtils;

public class WelcomeActivity extends AppCompatActivity {
    private static final String FIRST = "FIRSTS";
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what > 0) {
                handler.sendEmptyMessageDelayed(msg.what - 1, 1000);
            }
            if (msg.what == 0) {
                goHome();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getstart();


    }

    public void getstart() {
        //延迟2秒
        handler.sendEmptyMessageDelayed(2, 1000);
    }

    //跳转
    private void goHome() {
        startActivity(new Intent(this, LoginActivty.class));
        WelcomeActivity.this.finish();
    }

}
