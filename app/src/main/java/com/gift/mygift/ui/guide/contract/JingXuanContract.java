package com.gift.mygift.ui.guide.contract;

import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.ui.guide.onGuideLoadDataListener;

import java.util.List;

/**
 * 作者:  qiang on 2016/11/24 18:02
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public interface JingXuanContract {
    
    interface View{
        void onLoadSecondBanner(List<SendGiftData> SendGiftDatas);
    }

    interface Presenter{
        void loadSecondBanner();
    }

    interface Model{
        void getSecondBannerList(onGuideLoadDataListener listener);
    }


}