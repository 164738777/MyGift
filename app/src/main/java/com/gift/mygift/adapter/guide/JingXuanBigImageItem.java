package com.gift.mygift.adapter.guide;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseAdapterItem;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.tools.ImageTool;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;

/**
 * 作者:  qiang on 2016/11/24 10:16
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public class JingXuanBigImageItem extends BaseAdapterItem<SendGiftData> {


    @BindView(R.id.item_jingxuan_divider)
    View v_divider;
    @BindView(R.id.item_jingxuan_ll_time)
    LinearLayout ll_time;
    @BindView(R.id.item_jingxuan_tv_time)
    TextView tv_time;

    @BindView(R.id.item_jingxuan_tv_title)
    TextView tv_title;
    @BindView(R.id.item_jingxuan_iv_background)
    RoundedImageView iv_bg;
    @BindView(R.id.item_jingxuan_tv_likeCount)
    TextView tv_likeCount;

    private List<SendGiftData> mSendGiftDatas;

    public JingXuanBigImageItem(List<SendGiftData> sendGiftDatas) {
        this.mSendGiftDatas = sendGiftDatas;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_jingxuan_bigimage;
    }

    @Override
    public void handleData(SendGiftData sendGiftData, int i) {
        tv_title.setText(sendGiftData.title);
        ImageTool.loadImage(iv_bg,sendGiftData.cover_image_url);
        tv_likeCount.setText(sendGiftData.likes_count+"");

        long published_at = sendGiftData.published_at;

        if (i!=0
                &&mSendGiftDatas!=null
                &&!mSendGiftDatas.isEmpty()
                &&(published_at == mSendGiftDatas.get(i-1).published_at
                ||sendGiftData.timeText.equals(mSendGiftDatas.get(i-1).timeText))){
            ll_time.setVisibility(View.GONE);
        }else{
            v_divider.setVisibility(View.VISIBLE);
            ll_time.setVisibility(View.VISIBLE);
            tv_time.setText(sendGiftData.timeText);
        }
    }
}
