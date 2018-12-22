package com.qishui.contact.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

import com.qishui.contact.R;
import com.qishui.contact.fragment.ContactFragment;
import com.qishui.contact.fragment.HappyFragment;
import com.qishui.contact.fragment.MessageFragment;
import com.qishui.mylibrary.adapter.TabFragmentPagerAdapter;
import com.qishui.mylibrary.base.BaseActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected int initLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void intEvent(Bundle savedInstanceState) {

        setFragment();
        setDrawLayout();
    }

    @Override
    public void setTopColor() {
        drawerLayout = findViewById(R.id.drawer_layout);
        setTopDrawLayout(drawerLayout);
    }

    private void setDrawLayout() {

        findViewById(R.id.main_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            //这个方法每一帧会回调一次,slideOffset的值在0.0到1.0之间变动,当DrawerLayout关闭的时候是0.0,当DrawerLayout完全打开的时候是1.0
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // 得到contentView
                View content = drawerLayout.getChildAt(0);
                int offset = (int) (drawerView.getWidth() * slideOffset);
                // 设置是左移还是右移
                int value = drawerLayout.getChildAt(1).getVisibility();
                if (View.VISIBLE == value) {
                    content.setScrollX(-offset);
                } else {
                    content.setScrollX(offset);
                }

            }

            //这个方法每当DrawerLayout完全打开且手指从屏幕上松开的时候会回调
            @Override
            public void onDrawerOpened(View drawerView) {
            }

            //这个方法每当DrawerLayout完全关闭且手指从屏幕上松开的时候会回调
            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void setFragment() {

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ContactFragment());
        fragments.add(new MessageFragment());
        fragments.add(new HappyFragment());
        String[] titles = {"联系人", "动态","开心一刻"};

        TabFragmentPagerAdapter adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
    }

}
