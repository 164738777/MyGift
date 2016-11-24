package com.gift.mygift.network.api;

import com.gift.mygift.constant.RequestConstants;
import com.gift.mygift.entity.FirstBannerBean;
import com.gift.mygift.entity.HotBean;
import com.gift.mygift.entity.HotListBean;
import com.gift.mygift.entity.SecondBannerBean;
import com.gift.mygift.entity.SendGiftData;
import com.gift.mygift.network.ApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者:  qiang on 2016/11/17 20:08
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public interface NetApi {

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


    /**
     * http://api.liwushuo.com/v2/channels/10/items?limit=20&offset=0&gender=1&generation=2
     * @return 各种送页面
     */
    @GET("channels/{id}/items")
    Observable<ApiResponse<HotBean<SendGiftData>>> getSendGiftList(
            @Path("id") int channelID,
            @Query(RequestConstants.API_GENDER) int gender,
            @Query(RequestConstants.API_GENERATION) int generation,
            @Query(RequestConstants.API_LIMIT) int limit,
            @Query(RequestConstants.API_OFFSET) int offset);

    /**
     * http://api.liwushuo.com/v2/channels/10/items?limit=20&offset=0&gender=1&generation=2&ad=2
     * @return 各种送页面,有ad
     */
    @GET("channels/{id}/items")
    Observable<ApiResponse<HotBean<SendGiftData>>> getJingXuanList(
            @Path("id") int channelID,
            @Query(RequestConstants.API_GENDER) int gender,
            @Query(RequestConstants.API_GENERATION) int generation,
            @Query(RequestConstants.API_LIMIT) int limit,
            @Query(RequestConstants.API_OFFSET) int offset,
            @Query(RequestConstants.API_AD) int ad);


    /**
     * http://api.liwushuo.com/v2/secondary_banners?gender=1&generation=2
     * @return 精选广告轮播下面的横向小图
     */
    @GET("secondary_banners")
    Observable<ApiResponse<SecondBannerBean<SendGiftData>>> getJingXuanSecondBannerList(
            @Query(RequestConstants.API_GENDER) int gender,
            @Query(RequestConstants.API_GENERATION) int generation);


    /**
     * http://api.liwushuo.com/v2/banners
     * @return 精选广告轮播
     */
    @GET("banners")
    Observable<ApiResponse<FirstBannerBean<SendGiftData>>> getJingXuanFirstBannerList();


}
