package com.gift.mygift.ui;

import android.content.Context;
import android.os.Bundle;

import com.gift.mygift.R;
import com.gift.mygift.ui.base.BaseActivity;

public class HomeActivity extends BaseActivity {


    public static void start(Context context) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {

    }
}
