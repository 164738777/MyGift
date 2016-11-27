package com.gift.mygift.adapter.sort;

import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseAdapterItem;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.tools.ImageTool;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者:  qiang on 2016/11/27 21:40
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类攻略List Item
 */

public class SortGongLueListBeanItem extends BaseAdapterItem<SendGiftData> {


    @BindView(R.id.item_sort_gonglue_iv_cover)
    CircleImageView iv_cover;
    @BindView(R.id.item_sort_gonglue_tv_title)
    TextView tv_title;

    @Override
    public int getLayoutResId() {
        return R.layout.item_sort_gonglue;
    }

    @Override
    public void handleData(SendGiftData sendGiftData, int i) {
        tv_title.setText(sendGiftData.name);
        ImageTool.loadImage(iv_cover, sendGiftData.icon_url);
    }
}
