package com.example.administrator.mylive;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.MyPagerAdapter;
import utils.PrefsUtils;

public class MainActivity extends AppCompatActivity {
    private ViewPager mVp;
    private List<View> list;
    private static final String FIRST = "FIRST";
    private TextView mTv_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        if (PrefsUtils.get(this, FIRST)) {
            setContentView(R.layout.activity_main);
            //数据
            initDate();
            //找控件
            initView();
            //事件
            initEvent();
        } else {
            goHome();
        }

    }

    //跳转
    private void goHome() {
        PrefsUtils.save(this, FIRST, false);
        startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
        MainActivity.this.finish();
    }

    private void initEvent() {
        //点击进入
        mTv_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goHome();
            }
        });
        //滑动切换
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //切换到第三个页面时，显示textview
                mTv_start.setVisibility(position == 2 ? View.VISIBLE : View.GONE);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //创建集合
    private void initDate() {
        list = new ArrayList<View>();
        list.add(makeImageView(R.drawable.li_img_guide_1));
        list.add(makeImageView(R.drawable.li_img_guide_2));
        list.add(makeImageView(R.drawable.li_img_guide_3));


    }

    //找控件
    private void initView() {
        mTv_start = (TextView) findViewById(R.id.tv_start);
        mVp = (ViewPager) findViewById(R.id.vp);
        mVp.setAdapter(new MyPagerAdapter(list, MainActivity.this));
    }

    //创建自定位ImageView图片
    public ImageView makeImageView(int resId) {
        ImageView iv = new ImageView(this);
        iv.setBackgroundResource(resId);
        return iv;
    }
}
