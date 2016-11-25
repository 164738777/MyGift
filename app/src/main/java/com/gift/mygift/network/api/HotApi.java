package com.gift.mygift.network.api;

import com.gift.mygift.constant.RequestConstants;
import com.gift.mygift.entity.HotBean;
import com.gift.mygift.entity.HotListBean;
import com.gift.mygift.network.ApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者:  qiang on 2016/11/25 15:28
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public interface HotApi {
    /**
     * http://api.liwushuo.com/v2/items?limit=20&offset=0&gender=1&generation=2
     * @return 热门首页
     */
    @GET("items")
    Observable<ApiResponse<HotBean<HotListBean>>> getHotList(
            @Query(RequestConstants.API_GENDER) int gender,
            @Query(RequestConstants.API_GENERATION) int generation,
            @Query(RequestConstants.API_LIMIT) int limit,
            @Query(RequestConstants.API_OFFSET) int offset);
}
