package com.gift.mygift.adapter.sort;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseAdapterItem;
import com.gift.mygift.adapter.base.SuperRcvAdapter;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.entity.SortGongLueList;
import com.gift.mygift.tools.layoutmanager.FullyGridLayoutManager;

import butterknife.BindView;
import kale.adapter.item.AdapterItem;

/**
 * 作者:  qiang on 2016/11/27 21:40
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类攻略List Item
 */

public class SortGongLueListItem extends BaseAdapterItem<SortGongLueList> {

    @BindView(R.id.tv_module_title_with_rcv)
    TextView tv_title;
    @BindView(R.id.rcv_module_rcvlist)
    RecyclerView rcv;

    private SuperRcvAdapter<SendGiftData> mAdapter = new SuperRcvAdapter<SendGiftData>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new SortGongLueListBeanItem(context);
        }
    };

    private Context context;

    public SortGongLueListItem(Context context) {
        this.context = context;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.module_title_with_rcv;
    }

    @Override
    public void setViews() {
        FullyGridLayoutManager gridLayoutManager = new FullyGridLayoutManager(context, 4, LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(gridLayoutManager);
        rcv.setHasFixedSize(true);
        rcv.setAdapter(mAdapter);
    }

    @Override
    public void handleData(SortGongLueList sortGongLueListBean, int i) {
        tv_title.setText(sortGongLueListBean.name);
        mAdapter.notifyDataChanged(sortGongLueListBean.channels, true);
    }


}
