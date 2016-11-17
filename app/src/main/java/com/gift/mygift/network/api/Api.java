package com.gift.mygift.network.api;

import com.gift.mygift.constant.RequestConstants;
import com.gift.mygift.entity.HotBean;
import com.gift.mygift.network.ApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者:  qiang on 2016/11/17 20:08
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public interface Api {

    /**
     * @return 热门首页
     */
    @GET("items")
    Observable<ApiResponse<HotBean>> getHotList(
            @Query(RequestConstants.API_GENDER) int gender,
            @Query(RequestConstants.API_GENERATION) int generation,
            @Query(RequestConstants.API_LIMIT) int limit,
            @Query(RequestConstants.API_OFFSET) int offset);
}
