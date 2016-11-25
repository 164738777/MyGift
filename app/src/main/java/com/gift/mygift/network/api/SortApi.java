package com.gift.mygift.network.api;

import com.gift.mygift.constant.RequestConstants;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.entity.SortGongLueBean;
import com.gift.mygift.network.ApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者:  qiang on 2016/11/25 15:30
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public interface SortApi {


    /*攻略*/


    /**
     * http://api.liwushuo.com/v2/collections?limit=10&offset=0
     * @return 攻略专题首页
     */
    @GET("collections")
    Observable<ApiResponse<SortGongLueBean<SendGiftData>>> getSortGongLueZhuanTiList(
            @Query(RequestConstants.API_LIMIT) int limit,
            @Query(RequestConstants.API_OFFSET) int offset);
}
