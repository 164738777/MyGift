package com.gift.mygift.ui.hot;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.gift.mygift.adapter.base.SuperRcvAdapter;
import com.gift.mygift.adapter.hot.HotItem;
import com.gift.mygift.entity.HotListBean;
import com.gift.mygift.network.datasource.HotDS;
import com.gift.mygift.ui.base.RcvWithUpAndDownFragment;
import com.shizhefei.mvc.MVCHelper;
import com.shizhefei.mvc.MVCUltraHelper;

import java.util.List;

import kale.adapter.item.AdapterItem;

/**
 * 作者:  qiang on 2016/11/16 14:39
 * 邮箱:  anworkmail_q@126.com
 * 作用:  热门Frg
 */

public class HotFragment extends RcvWithUpAndDownFragment {

    private MVCHelper<List<HotListBean>> mvcHelper;
    private SuperRcvAdapter<HotListBean> mAdapter = new SuperRcvAdapter<HotListBean>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new HotItem();
        }
    };

    @Override
    protected void initView(View view) {
        //        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        //设置间隔变化,防止上拉加载的提示width变成一半
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == mAdapter.getItemCount())
                    return 2;
                else
                    return 1;
            }
        });
        rcv_list.setLayoutManager(manager);
        rcv_list.hasFixedSize();
        mvcHelper = new MVCUltraHelper<>(rl_list);
        mvcHelper.setDataSource(new HotDS());
        mvcHelper.setAdapter(mAdapter);
        mvcHelper.refresh();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void preRelease() {
        mvcHelper.destory();
    }
}
