package com.gift.mygift.adapter.sort;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.gift.mygift.R;
import com.gift.mygift.adapter.base.BaseRcvHeaderAdapterItem;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.tools.ImageTool;
import com.gift.mygift.tools.ToastTool;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者:  qiang on 2016/11/27 21:40
 * 邮箱:  anworkmail_q@126.com
 * 作用:  分类攻略List Item
 */

public class SortGongLueListBeanItem extends BaseRcvHeaderAdapterItem<SendGiftData> {


    @BindView(R.id.item_sort_gonglue_iv_cover)
    CircleImageView iv_cover;
    @BindView(R.id.item_sort_gonglue_tv_title)
    TextView tv_title;

    public SortGongLueListBeanItem(Context context) {
        this.context = context;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_sort_gonglue;
    }

    @Override
    public void handleData(SendGiftData sendGiftData, int i) {
        super.handleData(sendGiftData,i);
        tv_title.setText(sendGiftData.name);
        ImageTool.loadImage(iv_cover, sendGiftData.icon_url);
    }

    @Override
    public void onItemClick(View view, SendGiftData sendGiftData, int position) {
        ToastTool.show(context,sendGiftData.id+"");
    }
}
