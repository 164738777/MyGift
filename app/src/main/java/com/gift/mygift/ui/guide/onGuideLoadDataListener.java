package com.gift.mygift.ui.guide;

import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.ui.base.OnLoadDataListListener;

import java.util.List;

/**
 * 作者:  qiang on 2016/11/24 19:43
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public interface onGuideLoadDataListener extends OnLoadDataListListener<List<SendGiftData>> {
    void onSecondSuccess(List<SendGiftData> list);
    void onSecondFail(Throwable e);
}
