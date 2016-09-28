package com.example.administrator.mylive;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class LoginActivty extends Activity implements View.OnClickListener {

    private ImageView mIv_wx;
    private ImageView mIv_qq;
    private ImageView mIv_ph;
    private ImageView mIv_wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activty);

        initView();
        initEvent();

    }

    private void initEvent() {
        mIv_wx.setOnClickListener(this);
        mIv_qq.setOnClickListener(this);
        mIv_ph.setOnClickListener(this);
        mIv_wb.setOnClickListener(this);
    }

    //找控件
    private void initView() {
        mIv_wx = (ImageView) findViewById(R.id.iv_wx);
        mIv_qq = (ImageView) findViewById(R.id.iv_qq);
        mIv_ph = (ImageView) findViewById(R.id.iv_ph);
        mIv_wb = (ImageView) findViewById(R.id.iv_wb);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_wx:

                break;
            case R.id.iv_qq:
                UMShareAPI mShareAPI = UMShareAPI.get(LoginActivty.this);
                mShareAPI.doOauthVerify(LoginActivty.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.iv_ph:
                startActivity(new Intent(LoginActivty.this, PhoneMessageActivity.class));
                break;
            case R.id.iv_wb:

                break;

        }
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
