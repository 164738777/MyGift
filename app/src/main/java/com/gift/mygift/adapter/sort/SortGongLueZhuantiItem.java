package com.gift.mygift.adapter.sort;

import android.widget.ImageView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseAdapterItem;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.tools.ImageTool;

import butterknife.BindView;

/**
 * 作者:  qiang on 2016/11/24 17:48
 * 邮箱:  anworkmail_q@126.com
 * 作用:  精选中间小图Item
 */

public class SortGongLueZhuanTiItem extends BaseAdapterItem<SendGiftData> {

    @BindView(R.id.item_gonglue_zhuanti_iv)
    ImageView iv;


    @Override
    public int getLayoutResId() {
        return R.layout.item_gonglue_zhuanti;
    }

    @Override
    public void handleData(SendGiftData sendGiftData, int i) {
        ImageTool.loadImage(iv,sendGiftData.banner_image_url);
    }
}
