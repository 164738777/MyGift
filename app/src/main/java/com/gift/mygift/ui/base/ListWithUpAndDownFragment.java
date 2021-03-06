package com.gift.mygift.ui.base;

import android.widget.ListView;

import com.gift.mygift.R;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/**
 * 作者:  qiang on 2016/11/23 12:00
 * 邮箱:  anworkmail_q@126.com
 * 作用:  上下拉加载的list的Frg，listView版
 */

public abstract class ListWithUpAndDownFragment extends BaseFragment{

    @BindView(R.id.lv_module_list)
    protected ListView lv_list;
    @BindView(R.id.rl_module_list)
    protected PtrClassicFrameLayout rl_list;

    @Override
    protected int setContentViewId() {
        return R.layout.module_list_with_refresh;
    }
}
