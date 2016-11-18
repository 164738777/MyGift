package com.gift.mygift.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者:  qiang on 2016/11/16 12:05
 * 邮箱:  anworkmail_q@126.com
 * 作用:  基类Frg
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setContentViewId(), container, false);
        unbinder = ButterKnife.bind(this, view);

        initListener();
        initView();
        initData();

        return view;
    }

    protected abstract int setContentViewId();

    protected abstract void initView();
    protected abstract void initData();

    protected void initListener() {
    }

    protected void preRelease() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        preRelease();

        if (unbinder != null)
            unbinder.unbind();
    }
}
