package com.example.administrator.mylive;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;

import adapter.FragmentPgAdapter;
import fragment.Frag1;
import fragment.Frag2;
import fragment.Frag3;

public class MineActivity extends FragmentActivity {

    private ArrayList<Fragment> mList;
    private ViewPager mVp;
    private RadioGroup radioGroup;
    private FragmentPgAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        initDate();
        initView();
    }
    //数据
    private void initDate() {
        mList = new ArrayList<>();
        Frag1 frag1 = new Frag1();
        Frag2 frag2 = new Frag2();
        Frag3 frag3 = new Frag3();

        mList.add(frag1);
        mList.add(frag2);
        mList.add(frag3);

    }

    //找控件
    private void initView() {
        mVp = (ViewPager) findViewById(R.id.viewPager);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        fragmentAdapter = new FragmentPgAdapter(getSupportFragmentManager(), mList);
        mVp.setAdapter(fragmentAdapter);
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.bt_map1);
                        break;
                    case 1:
                        radioGroup.check(R.id.bt_map2);
                        break;
                    case 2:
                        radioGroup.check(R.id.bt_map3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt_map1:
                        mVp.setCurrentItem(0, true);
                        break;
                    case R.id.bt_map2:
                        mVp.setCurrentItem(1, true);
                        break;
                    case R.id.bt_map3:
                        mVp.setCurrentItem(2, true);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
