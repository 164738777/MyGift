package com.gift.mygift.adapter.sort;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseAdapterItem;
import com.gift.mygift.adapter.base.SuperRcvAdapter;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.entity.SortGiftList;
import com.gift.mygift.tools.layoutmanager.FullyGridLayoutManager;

import butterknife.BindView;
import kale.adapter.item.AdapterItem;

/**
 * 作者:  qiang on 2016/11/28 12:05
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类礼物Item
 */

public class SortGiftListItem extends BaseAdapterItem<SortGiftList> {

    @BindView(R.id.item_sort_gift_ll_title)
    LinearLayout ll_title;
    @BindView(R.id.item_sort_gift_tv_title)
    TextView tv_title;
    @BindView(R.id.rcv_module_rcvlist)
    RecyclerView rcv;

    private Context context;

    public SortGiftListItem(Context context) {
        this.context = context;
    }

    private SuperRcvAdapter<SendGiftData> mAdapter = new SuperRcvAdapter<SendGiftData>() {
        @NonNull
        @Override
        public AdapterItem createItem(Object o) {
            return new SortGiftListBeanItem(context);
        }
    };


    @Override
    public int getLayoutResId() {
        return R.layout.item_sort_gift;
    }

    @Override
    public void setViews() {
        FullyGridLayoutManager gridLayoutManager = new FullyGridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(gridLayoutManager);
        rcv.setHasFixedSize(true);
        rcv.setAdapter(mAdapter);
    }

    @Override
    public void handleData(SortGiftList sortGiftList, int i) {
        tv_title.setText(sortGiftList.name);
        mAdapter.notifyDataChanged(sortGiftList.subcategories, true);
    }
}
