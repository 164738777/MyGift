package com.gift.mygift.adapter.common;

import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseAdapterItem;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.tools.ImageTool;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;

/**
 * 作者:  qiang on 2016/11/23 15:50
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public class SendGiftItem extends BaseAdapterItem<SendGiftData> {

    @BindView(R.id.item_sendgift_tv_title)
    TextView tv_title;
    @BindView(R.id.item_sendgift_iv_background)
    RoundedImageView iv_bg;
    @BindView(R.id.item_sendgift_tv_likeCount)
    TextView tv_likeCount;


    @Override
    public int getLayoutResId() {
        return R.layout.item_sendgift;
    }

    @Override
    public void handleData(SendGiftData sendGiftData, int i) {
        tv_title.setText(sendGiftData.title);
        ImageTool.loadImage(iv_bg,sendGiftData.cover_image_url);
        tv_likeCount.setText(sendGiftData.likes_count+"");
    }
}
