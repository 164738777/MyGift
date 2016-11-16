package com.gift.mygift.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * 作者:  qiang on 2016/11/16 19:51
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */

public class NetWork {

    private static OkHttpClient okHttpClient = new OkHttpClient
            .Builder()
            //有网时使用的拦截器
            .addNetworkInterceptor(new StethoInterceptor())//调试用
            //所有情况下使用的拦截器
            //            .addInterceptor(new UrlInterceptor())
            /**
             * default timeout
             * connectTimeout = 10_000;
             * readTimeout = 10_000;
             * writeTimeout = 10_000;
             */
            .connectTimeout(10_000, TimeUnit.SECONDS)
            .readTimeout(10_000, TimeUnit.SECONDS)
            .writeTimeout(10_000, TimeUnit.SECONDS)
            .build();

    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

/*    private static Converter.Factory jsonAndXmlConverterFactory = new JsonAndXmlConverters.QualifiedTypeConverterFactory(
            FastJsonConverterFactory.create(),
            SimpleXmlConverterFactory.create());*/

    private static Retrofit.Builder getBuilder() {
        return new Retrofit.Builder()
                .client(okHttpClient)
                //                .addConverterFactory(jsonAndXmlConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory);
    }
}
