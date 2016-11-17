package com.gift.mygift.adapter.base;


import android.view.View;

import butterknife.ButterKnife;
import kale.adapter.item.AdapterItem;

/**
 * 作者:  qiang on 2016/11/17 21:16
 * 邮箱:  anworkmail_q@126.com
 * 作用:  基类Item
 */

public abstract class BaseAdapterItem<T> implements AdapterItem<T> {
    @Override
    public void bindViews(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void setViews() {

    }
}
