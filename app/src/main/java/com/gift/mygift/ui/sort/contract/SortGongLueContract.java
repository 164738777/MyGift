package com.gift.mygift.ui.sort.contract;

import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.ui.base.OnLoadDataListListener;

import java.util.List;

/**
 * 作者:  qiang on 2016/11/28 09:32
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public interface SortGongLueContract {

    public interface View {
        void loadZhuanTiBannerSuccess(List<SendGiftData> list);
    }

    public interface Presenter {
        void loadZhuanTiBanner();
    }

    public interface Model {
        void getZhuanTiBanner(OnLoadDataListListener<List<SendGiftData>> listener);
    }
}