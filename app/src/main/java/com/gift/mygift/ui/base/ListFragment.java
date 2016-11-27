package com.gift.mygift.ui.base;

import android.widget.ListView;

import com.gift.mygift.R;

import butterknife.BindView;

/**
 * 作者:  qiang on 2016/11/23 12:00
 * 邮箱:  anworkmail_q@126.com
 * 作用:  list的Frg，listView版
 */

public abstract class ListFragment extends BaseFragment{

    @BindView(R.id.lv_module_list)
    protected ListView lv_list;

    @Override
    protected int setContentViewId() {
        return R.layout.module_list;
    }
}
