package com.gift.mygift.network;

import com.socks.library.KLog;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author: Andecy;
 * Time: 2016/4/26;
 * Email: Andecy@foxmail.com;
 * Description: 网络拦截（主要是统一添加头部）
 *              这里不需要添加头部,所以用来显示网址
 */
public class UrlInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //        if (TextUtils.isEmpty(request.header(RequestConstants.API_SECRET))) {
        //            request = chain.request().newBuilder().addHeader(RequestConstants.API_SECRET, LancooUser.getSecret()).build();
        //        }
        KLog.w("url-->" + request.url());
        //        KLog.w("secret-->" + request.header(RequestConstants.API_SECRET));
        return chain.proceed(request);
    }
}
