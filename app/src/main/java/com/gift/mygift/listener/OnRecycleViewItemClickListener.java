package com.gift.mygift.listener;

import android.view.View;

/**
 * 作者:  qiang on 2016/12/1 13:50
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public interface OnRecycleViewItemClickListener<T> {
    void onItemClick(View view,T t, int position);
//    void onItemLongClick(View view, int position);
}
