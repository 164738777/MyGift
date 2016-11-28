package com.gift.mygift.adapter.sort;

import android.widget.ImageView;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseAdapterItem;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.tools.ImageTool;

import butterknife.BindView;

/**
 * 作者:  qiang on 2016/11/27 21:40
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类礼物List Item
 */

public class SortGiftListBeanItem extends BaseAdapterItem<SendGiftData> {


    @BindView(R.id.item_sort_gift_item_iv_cover)
    ImageView iv_cover;
    @BindView(R.id.item_sort_gift_item_tv_title)
    TextView tv_title;

    @Override
    public int getLayoutResId() {
        return R.layout.item_sort_gift_item;
    }

    @Override
    public void handleData(SendGiftData sendGiftData, int i) {
        tv_title.setText(sendGiftData.name);
        ImageTool.loadImage(iv_cover, sendGiftData.icon_url);
    }
}
