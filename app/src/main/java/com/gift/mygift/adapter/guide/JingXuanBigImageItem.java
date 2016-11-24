package com.gift.mygift.adapter.guide;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseAdapterItem;
import com.gift.mygift.constant.Constants;
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
    @BindView(R.id.item_jingxuan_iv_mask)
    RoundedImageView iv_mask;


    @BindView(R.id.item_jingxuan_ll_like)
    LinearLayout ll_like;
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
        /*判断type*/
        switch (sendGiftData.type) {
            case Constants.RESPONSE_TYPE_POST:
                tv_title.setVisibility(View.VISIBLE);
                iv_mask.setVisibility(View.VISIBLE);
                tv_title.setText(sendGiftData.title);
                ImageTool.loadImage(iv_bg,sendGiftData.cover_image_url);
                ll_like.setVisibility(View.VISIBLE);
                tv_likeCount.setText(sendGiftData.likes_count+"");
                break;
            case Constants.RESPONSE_TYPE_AD:
                tv_title.setVisibility(View.GONE);
                iv_mask.setVisibility(View.INVISIBLE);
                ll_like.setVisibility(View.GONE);
                ImageTool.loadImage(iv_bg,sendGiftData.image_url);
                break;
        }

        /*设置时间分组*/
        if (i!=0
                &&mSendGiftDatas!=null
                &&!mSendGiftDatas.isEmpty()
                &&sendGiftData.timeText.equals(mSendGiftDatas.get(i-1).timeText)){
            v_divider.setVisibility(View.GONE);
            ll_time.setVisibility(View.GONE);
        }else{
            v_divider.setVisibility(View.VISIBLE);
            ll_time.setVisibility(View.VISIBLE);
            tv_time.setText(sendGiftData.timeText);
        }
    }
}
