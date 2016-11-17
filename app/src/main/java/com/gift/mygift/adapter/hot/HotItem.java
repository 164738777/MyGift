package com.gift.mygift.adapter.hot;

import android.widget.ImageView;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseAdapterItem;
import com.gift.mygift.entity.HotData;
import com.gift.mygift.entity.HotListBean;
import com.gift.mygift.tools.ImageTool;

import butterknife.BindView;

/**
 * 作者:  qiang on 2016/11/17 20:50
 * 邮箱:  anworkmail_q@126.com
 * 作用:  热门首页item
 */

public class HotItem extends BaseAdapterItem<HotListBean> {

    @BindView(R.id.item_hot_iv_cover)
    ImageView iv_cover;
    @BindView(R.id.item_hot_tv_title)
    TextView tv_title;
    @BindView(R.id.item_hot_tv_price)
    TextView tv_price;
    @BindView(R.id.item_hot_tv_likecount)
    TextView tv_likeCount;

    @Override
    public int getLayoutResId() {
        return R.layout.item_hot;
    }

    @Override
    public void handleData(HotListBean hotListBean, int i) {
        HotData hotData = hotListBean.data;
        ImageTool.loadImage(iv_cover, hotData.cover_image_url);
        tv_title.setText(hotData.name);
        tv_price.setText(hotData.price);
        tv_likeCount.setText(hotData.favorites_count + "");
    }

}
