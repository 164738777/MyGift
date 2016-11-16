package com.gift.mygift.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.gift.mygift.R;
import com.gift.mygift.ui.base.BaseActivity;

public class HolderActivity extends BaseActivity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(HolderActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_holder;
    }

    @Override
    protected void initView() {

    }
}
