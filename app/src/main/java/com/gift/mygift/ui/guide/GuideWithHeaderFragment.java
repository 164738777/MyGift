package com.gift.mygift.ui.guide;

import com.gift.mygift.R;
import com.gift.mygift.ui.base.BaseFragment;

/**
 * 作者:  qiang on 2016/11/23 11:55
 * 邮箱:  anworkmail_q@126.com
 * 作用:  指南有Header的Frg(例如精选)
 */

public class GuideWithHeaderFragment extends BaseFragment {

    public static GuideWithHeaderFragment newInstance(){
        return new GuideWithHeaderFragment();
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
