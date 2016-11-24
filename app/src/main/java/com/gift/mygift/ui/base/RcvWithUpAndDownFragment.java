package com.gift.mygift.ui.base;

import android.support.v7.widget.RecyclerView;

import com.gift.mygift.R;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/**
 * 作者:  qiang on 2016/11/23 12:00
 * 邮箱:  anworkmail_q@126.com
 * 作用:  上下拉加载的list的Frg，recyclerview版的
 */

public abstract class RcvWithUpAndDownFragment extends BaseFragment{

    @BindView(R.id.rcv_module_rcvlist)
    protected RecyclerView rcv_list;
    @BindView(R.id.rl_module_rcvlist)
    protected PtrClassicFrameLayout rl_list;

    @Override
    protected int setContentViewId() {
        return R.layout.module_rcvlist;
    }
}
