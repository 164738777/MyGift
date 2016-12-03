package com.gift.mygift.adapter.base;


import android.content.Context;
import android.view.View;

import com.gift.mygift.listener.OnRecycleViewItemClickListener;
import com.socks.library.KLog;

/**
 * 作者:  qiang on 2016/11/17 21:16
 * 邮箱:  anworkmail_q@126.com
 * 作用:  基类RecyclerView Item,默认添加根布局点击事件
 *        只适用于Header是Rcv的
 */

public abstract class BaseRcvHeaderAdapterItem<T> extends BaseAdapterItem<T> implements View.OnClickListener ,OnRecycleViewItemClickListener<T>{

    private View rootView;
    private OnRecycleViewItemClickListener rcvClickListener;
    private int mPosition;
    private T t;
    protected Context context;

    private void setRcvClickListener(OnRecycleViewItemClickListener listener){
        this.rcvClickListener = listener;
    }

    @Override
    public void bindViews(View view) {
        super.bindViews(view);
        rootView = view;
        rootView.setOnClickListener(this);
        setRcvClickListener(this);
    }

    @Override
    public void handleData(T t, int i) {
        this.t = t;
        this.mPosition = i;
    }

    @Override
    public void onClick(View v) {
        if (rcvClickListener!=null){
            rcvClickListener.onItemClick(rootView,t,mPosition);
        }
    }
}
