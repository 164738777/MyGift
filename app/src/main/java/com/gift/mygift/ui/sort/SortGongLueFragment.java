package com.gift.mygift.ui.sort;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者:  qiang on 2016/11/25 11:33
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类里面的攻略Frg
 */

public class SortGongLueFragment extends BaseFragment {


    @BindView(R.id.tv_gongLue_seeAll)
    TextView tv_gongLue_seeAll;
    @BindView(R.id.rcv_module_rcvlist)
    RecyclerView rcv_zhuanTi;

    private TextView tv_pinLei, tv_style, tv_object;
    private RecyclerView rcv_pinLei, rcv_style, rcv_object;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_sort_gonglue;
    }

    @OnClick({R.id.tv_gongLue_seeAll})
    public void onTextClick(View view) {
        switch (view.getId()) {
            case R.id.tv_gongLue_seeAll:
                break;
        }
    }

    @Override
    protected void initView(View view) {
        LinearLayout ll_pinLei = ButterKnife.findById(view, R.id.ll_gongLue_pinLei);
        tv_pinLei = ButterKnife.findById(ll_pinLei, R.id.tv_module_title_with_rcv);
        rcv_pinLei = ButterKnife.findById(ll_pinLei, R.id.rcv_module_rcvlist);

        LinearLayout ll_style = ButterKnife.findById(view, R.id.ll_gongLue_style);
        tv_style = ButterKnife.findById(ll_style, R.id.tv_module_title_with_rcv);
        rcv_style = ButterKnife.findById(ll_style, R.id.rcv_module_rcvlist);

        LinearLayout ll_object = ButterKnife.findById(view, R.id.ll_gongLue_object);
        tv_object = ButterKnife.findById(ll_object, R.id.tv_module_title_with_rcv);
        rcv_object = ButterKnife.findById(ll_object, R.id.rcv_module_rcvlist);

        tv_pinLei.setText(getResources().getString(R.string.sort_gongLue_title_pinLei));
        tv_style.setText(getResources().getString(R.string.sort_gongLue_title_style));
        tv_object.setText(getResources().getString(R.string.sort_gongLue_title_object));
    }

    @Override
    protected void initData() {

    }

}
