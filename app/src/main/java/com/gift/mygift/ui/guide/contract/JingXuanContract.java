package com.gift.mygift.ui.guide.contract;

import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.listener.OnLoadDataListListener;
import com.gift.mygift.ui.guide.onGuideLoadDataListener;

import java.util.List;

/**
 * 作者:  qiang on 2016/11/24 18:02
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public interface JingXuanContract {
    
    interface View{
        void onLoadFirstBanner(List<SendGiftData> SendGiftDatas);
        void onLoadSecondBanner(List<SendGiftData> SendGiftDatas);
    }

    interface Presenter{
        void loadFirstBanner();
        void loadSecondBanner();
    }

    interface Model{
        void getFirstBannerList(OnLoadDataListListener<List<SendGiftData>> listener);
        void getSecondBannerList(onGuideLoadDataListener listener);
    }


}