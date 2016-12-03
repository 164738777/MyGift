package com.gift.mygift.adapter.guide;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseRcvHeaderAdapterItem;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.tools.ImageTool;
import com.gift.mygift.tools.ToastTool;

import butterknife.BindView;

/**
 * 作者:  qiang on 2016/11/24 17:48
 * 邮箱:  anworkmail_q@126.com
 * 作用:  精选中间小图Item
 */

public class JingXuanSecondBannerItem extends BaseRcvHeaderAdapterItem<SendGiftData> {

    @BindView(R.id.item_jingxuan_secondbanner_iv)
    ImageView iv;

    public JingXuanSecondBannerItem(Context context) {
        this.context = context;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_jingxuan_secondbanner;
    }


    @Override
    public void handleData(SendGiftData sendGiftData, int i) {
        super.handleData(sendGiftData,i);
        ImageTool.loadImage(iv, sendGiftData.image_url);
    }


    @Override
    public void onItemClick(View view, SendGiftData sendGiftData, int position) {
        ToastTool.show(context,sendGiftData.id+"");
    }
}
