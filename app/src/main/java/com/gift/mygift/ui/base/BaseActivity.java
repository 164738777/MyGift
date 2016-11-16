package com.gift.mygift.ui.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 基类Aty
 * Created by qiang on 2016/11/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewId());

        ButterKnife.bind(this);

        initListener();
        initView();
    }

    protected abstract int setContentViewId();

    protected abstract void initView();

    protected void initListener() {
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        preRelease();
    }

    protected void preRelease() {
    }

    /**
     * 恢复标题栏
     * @param title
     */
    protected void restoreActionBar(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            return;
        }
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(true);//是否显示左上角返回按钮
        actionBar.setElevation(0);
    }
}

